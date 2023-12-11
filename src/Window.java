import javax.swing.*;

public class Window extends JFrame {

    static int windowWidth = 800;
    static int windowHeight = (windowWidth/16) * 9;
    public Window(Panel panel){
        this.setVisible(true);
        this.setTitle("Game Window");
        this.setSize(windowWidth, windowHeight);
        this.setResizable(true);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
    }
}
