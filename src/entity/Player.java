package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
import main.KeyHandler;
import util.Point;
import util.Vector;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    Vector velocity = new Vector(0,0);
    Vector gravity = new Vector(0, 9.8f);
    Vector jumpVelocity = new Vector(0,7);
    int JUMP_TICKS = 10;
    Point pos = new Point(0,0);
    boolean jumping = false;
    boolean deaccelearating = false;

    int counter;
    

    public Player(GamePanel gp,KeyHandler keyH, int x, int y, int width, int height, int speed){
        this.gp = gp;
        this.keyH = keyH;
        defaultData[0] = x;
        defaultData[1] = y;

        defaultData[2] = width;
        defaultData[3] = height;

        defaultData[4] = speed;

        reset();
    }

   
  


    public void update(){
        kl();

        if (jumping){
            
            if(deaccelearating == false){
                counter++;
                velocity.y = -jumpVelocity.y;
                if (counter > JUMP_TICKS){
                    deaccelearating = true;
                }
            }else{
                counter--;
                velocity.y = jumpVelocity.y;
                if(counter < 1){
                    deaccelearating = false;
                    jumping = false;
                }
            }
        }


        pos.x += velocity.x * gp.dt;
        pos.y += velocity.y * gp.dt;


        // Keeping player in borders
        if(pos.x + velocity.x < 0){
            pos.x = 0;
        }
        if(pos.y + velocity.y < 0){
            pos.y = 0;
        }
        if(pos.x + velocity.x + this.width > gp.screenWidth){
            pos.x = gp.screenWidth - this.width;
        }
        if(pos.y + velocity.y + this.height > gp.screenHeight){
            pos.y = gp.screenHeight - this.height;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.yellow);
        g2.fillRect((int)pos.x,(int)pos.y,width,height);
    }
    
    void kl(){
        if (keyH.sPressed){
            this.velocity.y = 15;
        }else{
            this.velocity.y = 0;
                if (keyH.spacePressed && jumping == false){
                    jumping = true;
                    keyH.spacePressed = false;
                    counter = 0;
                }else{
                    if (!jumping)
                        velocity.y = gravity.y;
                    if (keyH.aPressed){
                        this.velocity.x = -15;
                    }else{
                        this.velocity.x = 0;
                            if (keyH.dPressed){
                                this.velocity.x = 15;
                            }else{
                                this.velocity.x = 0;      
                            }
                        }  
                    }
            }
                
    }
}
