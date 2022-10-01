package main;

import javax.swing.JPanel;

import entity.Player;
import entity.particles.foam;
import ui.UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;


public class GamePanel extends JPanel implements Runnable{
    public double dt = 0;
    Thread gameThread;
    int FPS = 60;
    public final int screenWidth = 768; //768px
    public final int screenHeight = 576;//576px
    public KeyHandler keyH = new KeyHandler(this);
    UI ui = new UI(this);
    public int recFPS;
    
    
    /**
     * <ul>
     * </ul>
     */
    public int gameState = 0;

    
    public Player player = new Player(this, keyH, 100, 200, 40, 80, 7);


    public foam particles[] = new foam[0];


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        for (int i = 0; i < particles.length; i++){
            particles[i] = new foam(this, (int) (Math.random()*screenWidth),(int)(Math.random()*screenHeight), 5, 5);
        }
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; //0.016666s
        long lastTime = System.nanoTime();
        long currentTime = 0;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){
            currentTime = System.nanoTime();
            this.dt += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(this.dt > 1){
                update();
                repaint();
                this.dt--;
                drawCount++;
            }

            if (timer >=1000000000){
                recFPS = drawCount;
                timer =0;
                drawCount = 0;
            }
        }
    }
    
    public void update(){
        ui.update();
        player.update();
        for (int i = 0; i < particles.length; i++) {
            particles[i].update();
        }
        
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);
        
        for (int i = 0; i < particles.length; i++) {
            particles[i].draw(g2);
        }
        ui.draw(g2);
        
        g2.dispose();
    }
}
