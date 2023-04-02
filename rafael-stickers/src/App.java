import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // NASA
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //ContentExtractor contentExtractor = new contentExtractorNasa();
        
        // IMDB
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //ContentExtractor contentExtractor = new contentExtractorIMDB();

        // localhost
        String url = "http://localhost:8080/linguagens";
        ContentExtractor contentExtractor = new contentExtractorIMDB();

        // Conexão HTTP
        var http = new ClientHttp();
        String json = http.searchData(url);
        
        // Chama o gerador e manda para a pasta

        var StickerGenerator = new StickerGenerator();
        List<Content> contents = contentExtractor.contentExtraList(json);
        
        for (int i = 0; i < 3; i++) {
            Content content = contents.get(i);
            
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = "output/"+(content.getTitle())+".png";
            
            StickerGenerator.create(inputStream, fileName);
            System.out.println(content.getTitle());
        
    }
}
}
 