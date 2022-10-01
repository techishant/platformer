package util;

public class Vector {
    public float x;
    public float y;

    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Vector(){
    }

    public Vector subVector(Point a, Point b){
        Vector v = new Vector();

        v.x = a.x - b.x;
        v.y = a.y - b.y;

        return v;
    }
}
