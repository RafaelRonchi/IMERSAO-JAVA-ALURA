public enum API {
    IMDB("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new contentExtractorIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", new contentExtractorNasa()),
    LOCAL("http://localhost:8080/linguagens", new contentExtractorIMDB());
    private String url;
    private ContentExtractor extrator;
    
    API(String url, ContentExtractor extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ContentExtractor getExtrator() {
        return extrator;
    }
}
