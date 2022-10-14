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
    Point currentPosBeforeJump = new Point(0,0);
    private boolean jump = false;
    private boolean deacceleratingJump = false;
    private int jumpHeight = 40;
    public float speed = 5;

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

    public void jumpMechanics(){
        float displacement = this.currentPosBeforeJump.y - this.pos.y;

        if(displacement >= jumpHeight){
            deacceleratingJump = true;
        }
        if (deacceleratingJump){
            this.velocity.y = 0;
            gravity.y = 9.8f;
            if(this.pos.y >= this.currentPosBeforeJump.y){
                jump = false;
                deacceleratingJump = false;
            }
        }else{
            gravity.y = 0;
            this.velocity.y += -(float) Math.sqrt(Math.abs(2 * 9.8 * jumpHeight));
        }
    }

   
  


    public void update(){
        kl();

        if (jump){
            jumpMechanics();
        }


        pos.x += velocity.x * gp.dt;
        pos.y += (velocity.y + gravity.y) * gp.dt;
        // System.out.println((velocity.y + gravity.y) * gp.dt);

        

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
        if(keyH.wPressed){
            this.velocity.y = -speed;
        }else{
            this.velocity.y = 0;
            if(keyH.dPressed){
                this.velocity.x = speed;
            }else{
                this.velocity.x = 0;
                if(keyH.sPressed){
                    this.velocity.y = speed;
                }else{
                    this.velocity.y = 0;
                    if(keyH.aPressed){
                        this.velocity.x = -speed;
                    }else{
                        this.velocity.x = 0;
                        if(keyH.spacePressed){
                            if(!jump){
                                this.currentPosBeforeJump.x = this.pos.x;
                                this.currentPosBeforeJump.y = this.pos.y;
                                jump = true;
                            }
                        }
                    }
                }
            }
        }   
    }
}
