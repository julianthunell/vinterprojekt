public class Game implements Runnable{
    private Window window;
    private Panel panel;
    private Thread gameThread;
    private final int fps = 60;
    private final int ups = 120;


    public Game(){

        //gamestart
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

    public void update(){
        panel.updateGame();
        Input.playerMovement();
    }

    @Override
    public void run() {

        //render variables
        double frameTime = 1000000000.0 /fps;
        double updateTime = 1000000000.0 /ups;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        //fps variables
        long frames = 0;
        long lastTime = 0;

        //update variables
        long previousTime = System.nanoTime();
        double deltaU = 0;
        double deltaF = 0;
        int updates = 0;

        //infinite loop
        while (true){
            now = System.nanoTime();
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) /updateTime;
            previousTime = currentTime;

            //update
            if (deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }
            //render
            if (now - lastFrame >= frameTime){
                panel.repaint();
                lastFrame = now;
                frames++;
            }

            //fps counter
            if(System.currentTimeMillis() - lastTime >= 1000){
                lastTime = System.currentTimeMillis();
                System.out.println("FPS: "+frames +"ups:" + updates);
                frames = 0;
                updates = 0;
            }

        }

    }
}
