package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.GamePanel;
import util.Font$;

public class UI {
    GamePanel gp;
    Font arial_40;
    Font consolas_20;
    Font$ font;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        consolas_20 = new Font("Consolas", Font.PLAIN, 20);
        font = new Font$(gp);
    }

    public void update(){
    }


    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
        g2.setFont(consolas_20);
        g2.drawString("FPS: " + gp.recFPS, gp.screenWidth-20*5, 20);
        // g2.drawString("Particles: " + gp.particles.length, 10, 60);
    }
}
