public class Game implements Runnable{
    private Window window;
    private Panel panel;
    private Thread gameThread;
    private final int fps = 60;


    public Game(){
        panel = new Panel();
        window = new Window(panel);
        panel.requestFocus();
        startGameloop();
    }

    //starta gameloop
    private void startGameloop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        //tids variablar
        double frameTime = 1000000000.0 /fps;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        while (true){

            now = System.nanoTime();
            if (now - lastFrame >= frameTime){
                panel.repaint();
                lastFrame = now;
            }

        }

    }
}
