import com.sun.source.tree.CaseTree;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
    static boolean playerDown, playerUp, playerRight, playerLeft;

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int input = (e.getKeyCode());
        System.out.println(e.getKeyCode());

        //movement input
        switch (input){
            case 87:
                playerUp =true;
                System.out.println("test");
                break;
            case 83:
                playerDown=true;
                break;
            case 65:
                playerLeft =true;
                break;
            case 68:
                playerRight =true;
                break;
        }
        //other
    }
    public void keyReleased(KeyEvent e) {
        int input = (e.getKeyCode());
        //System.out.println(input);
        switch (input) {
            case 87:
                playerUp = false;
                break;
            case 83:
                playerDown = false;
                break;
            case 65:
                playerLeft = false;
                break;
            case 68:
                playerRight = false;
                break;
        }
    }
    public static void playerMovement(){
        if(playerRight){
            Player.X+=Player.vel;
        }
        if(playerRight){
            Player.Y-=Player.vel;
        }
    }
}
