package entity;

import java.awt.Rectangle;

import util.Point;

public class Entity {
    /**
     * <ol> 
     * <li>x</li>
     * <li>y</li>
     * <li>width</li>
     * <li>height</li>
     * <li>speed</li>
     * <li>collisionX</li>
     * <li>collisionY</li>
     * <li>collisionWidth</li>
     * <li>collisionHeight</li>
     * </ol> 
     * x, y, width, height, speed,collisionX,collisionY, collisionWidth, collisionHeight
     */
    int[] defaultData = new int[9];
    public int x, y;
    public int cx, cy;
    public int height,width;

    public float speed;

    boolean collision = false;

    public Rectangle solidArea;
    
    Point pos = new Point(0, 0);




    public void reset(){
        this.x = defaultData[0];
        this.y = defaultData[1];
        this.width = defaultData[2];
        this.height = defaultData[3];
        this.speed = defaultData[4];
        if (collision == true){
        solidArea = new Rectangle(defaultData[5], defaultData[6], defaultData[7], defaultData[8]);
        }

        cx = x + width/2;
        cy = y + height/2;

        pos.x = defaultData[0];
        pos.y = defaultData[1];
    }
}

