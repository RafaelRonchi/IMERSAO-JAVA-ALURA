import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class contentExtractorIMDB implements ContentExtractor{
    public List<Content> contentExtraList(String json ){
        // Extrai os dados do JSON
        JsonParser parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // Popula a lista
        for (Map<String, String> attribute : attributesList) {
            String title = attribute.get("title");
            String urlImg = attribute.get("image").replaceAll("(@+)(.*).jpg$","$1.jpg");
            var content = new Content(title , urlImg);

            contents.add(content);
        }

        return contents;
    }
}
