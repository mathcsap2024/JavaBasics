package MultiThreading;

public class Application implements Runnable{
    @Override
    public void run() {
        Thread mainThread = new Thread(new MainApplication());
        Thread sideThread = new Thread(new SideApplication());
        Thread extendedThread = new ExtendedThread();

        mainThread.start();
        sideThread.start();
        extendedThread.start();
    }
}
