package MultiThreading;

import java.awt.*;
import java.util.concurrent.Semaphore;

public class Application implements Runnable{
    @Override
    public void run() {

        APSemaphore apSemaphore = null;
        try {
            apSemaphore = new APSemaphore();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Semaphore semaphore=new Semaphore(1);

        Thread mainThread = new Thread(new MainApplication(apSemaphore));
        Thread sideThread = new Thread(new SideApplication(apSemaphore));
        Thread extendedThread = new ExtendedThread(apSemaphore);

        mainThread.start();
        sideThread.start();
        extendedThread.start();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        extendedThread.interrupt();
    }
}
