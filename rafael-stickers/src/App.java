import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        // IMDB
        //API api = API.IMDB;
        
        // NASA
        //API api = API.NASA;

        // LOCAL HOST
        API api = API.LOCAL;

        String url = api.getUrl();
        ContentExtractor contentExtractor = api.getExtrator();

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
 