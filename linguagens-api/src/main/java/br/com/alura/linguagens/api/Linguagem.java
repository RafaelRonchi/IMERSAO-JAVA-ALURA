package br.com.alura.linguagens.api;

public class Linguagem {
    private String title;
    private String image;
    private Integer ranking;
    
    public Linguagem(String title, String image, Integer ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }
    
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public Integer getRanking() {
        return ranking;
    }

    
}
