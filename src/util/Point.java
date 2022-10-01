package util;

public class Point {
    public float x;
    public float y;


    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Point addVector(Vector v){
        Point p2 = new Point(x, y);
        p2.x += v.x;
        p2.y += v.y;

        return p2;
    }
    
    public Point subVector(Vector v){
        Point p2 = new Point(x, y);
        p2.x -= v.x;
        p2.y -= v.y;

        return p2;
    }
    public Point mulVector(Vector v){
        Point p2 = new Point(x, y);
        p2.x *= v.x;
        p2.y *= v.y;

        return p2;
    }
    public Point divVector(Vector v){
        Point p2 = new Point(x, y);
        p2.x /= v.x;
        p2.y /= v.y;

        return p2;
    }

}
