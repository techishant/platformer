package tiles;
import java.awt.image.BufferedImage;

import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class Tile {
    int height = 64;
    int width = 64;
    int x = 70;
    int y = 30;
    int scale = 0;
    long id;
    int tile;
    BufferedImage tileImg;

    public Tile(int tile){
        id =(long) Math.random()*(10 * 6);
        this.tile = tile;

        loadImage();
    }

    private void loadImage(){
        try{
            tileImg = ImageIO.read(getClass().getResourceAsStream(constants.getPath(tile)));
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(tile);
    }

    public void update(){

    }

    public void draw(Graphics2D g2){
        g2.drawImage(tileImg, x, y, width, height, null);
    }
}
