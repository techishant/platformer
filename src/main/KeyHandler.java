package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gp = null;
    public boolean wPressed, aPressed, sPressed, dPressed, spacePressed;
    

    public KeyHandler(GamePanel gp){
        this.gp = gp;
        aPressed = false;
        wPressed = false;
        sPressed = false;
        dPressed = false;
        spacePressed = false;
    } 

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            wPressed = true;
        }
        if(code == KeyEvent.VK_SPACE){
            spacePressed = true;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            aPressed = true;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            sPressed = true;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            dPressed = true;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        switch(gp.gameState){
            case 0:
            break;
        }
        if(code == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            wPressed = false;
        }
        
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            aPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            sPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            dPressed = false;
        }    


        
        if(code == KeyEvent.VK_P){
            gp.gameState = (gp.gameState == -1)? 1: -1; // PAUSE MECHANICS
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Just a ritual: Not to be used
    }
    
}