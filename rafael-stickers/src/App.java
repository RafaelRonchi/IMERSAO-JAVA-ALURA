import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Conexão HTTP
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI addresUri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(addresUri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> filmList = parser.parse(body);
        
        // exibe
        for (Map<String,String> filmMap : filmList) {   
            
            
            var StickerGenerator = new StickerGenerator();
                InputStream inputStream = new URL((filmMap.get("image"))).openStream();
                String fileName = "rafael-stickers/output/"+(filmMap.get("title"))+".png";
                StickerGenerator.create(inputStream, fileName);
         
            System.out.println(filmMap.get("title"));
            System.out.println(filmMap.get("image"));
            System.out.println(filmMap.get("imDbRating"));
        }
        
    }
}
 