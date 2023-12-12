import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    long lastTime = 0;
    int velocity = 1;
    long frames = 0;

    int x = 0;
    int y = 0;
    public Panel(){
        this.setSize(Window.windowWidth, Window.windowHeight);
        this.setBackground(Color.cyan);
    }
    public void paintComponent(Graphics g){
        g.fill3DRect(x+velocity,y+velocity,30,30,true);
        if(y == Window.windowHeight )

        frames++;
        if(System.currentTimeMillis() - lastTime >= 1000){
            lastTime = System.currentTimeMillis();
            System.out.println("FPS: "+frames);
            frames = 0;
        }
    }
}