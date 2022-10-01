package entity.particles;
import java.awt.Color;
import java.awt.Graphics2D;
import main.GamePanel;


public class foam {
    int x;
    int y;
    int width;
    int height;
    int speedX = (int)(Math.random() * 5) + 1;
    int speedY = (int)(Math.random() * 5) + 1;
    GamePanel gp;
    boolean away = false;
    double hypo;
    int speedIncCount;
    
    public foam(GamePanel gp, int x, int y, int width, int height){
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    int OriginalSpeedX;
    int OriginalSpeedY;
    public void update(){
        if (speedIncCount > 0){
            speedIncCount++;
            OriginalSpeedX = speedX;
            OriginalSpeedY = speedY;

            speedX = speedX/Math.abs(speedX) * (int) gp.player.speed;
            speedY = speedY/Math.abs(speedY) * (int) gp.player.speed;
            if (speedIncCount > 60){
                speedIncCount =0;
                speedX = OriginalSpeedX;
                speedY = OriginalSpeedY;
            }
        }


        x += speedX * gp.dt;
        y += speedY * gp.dt;


        if (x <= 0 || this.x >= gp.screenWidth-width){
            speedX *= -1;
        }
        if(y <= 0 || y >= gp.screenHeight-height){
            speedY *= -1;
        }

        hypo = Math.abs(((gp.player.x + gp.player.width/2) - (this.x + width/2)) * ((gp.player.x + gp.player.width/2) - (this.x + width/2)) + ((gp.player.y + gp.player.height/2) - (this.y + height/2)) *  ((gp.player.y + gp.player.height/2) - (this.y + height/2)));
        
        if (hypo < 10000 && away == false){
                speedIncCount ++;
                away = true;
                speedX *= -1;
                speedY *= -1;
            }
        if (hypo >= 10000 && away == true){
            away = false;
        }

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillOval(x,y,width,height);
    }
}
