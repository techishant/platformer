package util;

public class LERP {
    
    public float approach(float goal, float current, float dt){
        float diff = goal - current;

        if (diff > dt){
            return current + dt;
        }
        if (diff < -dt){
            return current - dt;
        }

        return goal;
    }
}
