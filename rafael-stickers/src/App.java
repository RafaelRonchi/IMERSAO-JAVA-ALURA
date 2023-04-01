import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Conexão HTTP
        String url = "https://api.nasa.gov/planetary/apod?api_key=d45MiFfPJ9HHosFGZNar3vl6U4KaezBMdT2wFpZW&start_date=2022-06-12&end_date=2022-06-16";
        
        var http = new ClientHttp();
        String json = http.searchData(url);

        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> contentList = parser.parse(json);
        
        // exibe
        for (Map<String,String> content : contentList) {   
            
            System.out.println(content.get("title"));
            System.out.println(content.get("url"));
            System.out.println(content.get("imDbRating"));
            
            var StickerGenerator = new StickerGenerator();
                InputStream inputStream = new URL((content.get("url"))).openStream();
                String fileName = "rafael-stickers/output/"+(content.get("title"))+".png";
                StickerGenerator.create(inputStream, fileName);
         
        }
        
    }
}
 