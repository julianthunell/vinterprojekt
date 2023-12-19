import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    static int windowWidth = 800;
    static int windowHeight = (windowWidth/16) * 9;
    long lastTime = 0;
    int velocity_y = 2;
    int velocity_x = 2;


    int x = 0;
    int y = 0;
    public Panel(){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
    }
    public void updateGame(){

    }
    public void paintComponent(Graphics g){
        g.fillRect(0, World.floorLimit,windowWidth,100);
        g.fillRect(Player.X,Player.Y,Player.width,Player.height);
    }
}