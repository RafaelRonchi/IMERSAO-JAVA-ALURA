import java.awt.Color;
import java.awt.Font;
//import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
import java.io.InputStream;
//import java.net.URL;

import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public void create(InputStream inputStream, String fileName) throws Exception{
        //Ler img
        //InputStream inputStream = new FileInputStream(new File("rafael-stickers/entrada/TopMovies_1.jpg"));
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();



        BufferedImage originalImg = ImageIO.read(inputStream);

        // Cria nova img
        int width = originalImg.getWidth(); //674
        int height = originalImg.getHeight(); //1000
        int newHeight = height + 200;
        BufferedImage newImg = new BufferedImage( width,  newHeight, BufferedImage.TRANSLUCENT);

        // Copiar img original para nova img 
        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(originalImg, 0, 0, null);

        // Configurar texto 
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setColor(Color.ORANGE);
        graphics.setFont(font);

        // Escrever frase
        graphics.drawString("TOP D+", ((width/2)-(width/4)), (newHeight-100));
        
        // Escrever a nova imagem em arquivo
        ImageIO.write(newImg, "png", new File(fileName));
    }

    /* public static void main(String[] args) throws Exception {
        StickerGenerator stickerGenerator = new StickerGenerator();
        stickerGenerator.create();
    } */
}
