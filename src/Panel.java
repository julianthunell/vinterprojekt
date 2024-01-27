import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener {
    static int windowWidth = 800;
    static int windowHeight = (windowWidth/16) * 9;
    long lastTime = 0;
    int velocity_y = 2;
    int velocity_x = 2;
    Player player;
    Game myGame;



    int x = 0;
    int y = 0;
    public Panel(Player player){
        this.player =player;
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.addKeyListener(this);
    }
    public void updateGame(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(0, World.floorLimit,windowWidth,100);
        g.fillRect(player.x,player.y,player.width,player.height);
    }
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
    public void playerMovement(){
        if(playerRight && player.x < (Panel.windowWidth - player.width)){
            player.x+= player.vel;
        }
        if(playerLeft && player.x > 0){
            player.x-= player.vel;
        }

        if (player.y+ player.height < World.floorLimit){
            player.y+= player.vel;
        }
    }

}
