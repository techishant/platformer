package tiles;

public class constants {
    public static String path;
    public static int GRASS = 1;


    public static String getPath(int tile){
        switch (tile) {
            case 1:
                path = "/res/grass.png";
                break;
            default:
                break;
        }
        return path;
    }
}
