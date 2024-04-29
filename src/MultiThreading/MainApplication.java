package MultiThreading;

import java.awt.*;
import java.util.concurrent.Semaphore;

public class MainApplication implements Runnable {

//    private Object lock;
//
//    MainApplication(Object lock) {
//        this.lock = lock;
//    }
//
//    MainApplication() {
//        this(Color.RED);
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            synchronized (lock) {
//                System.out.print(i);
//                System.out.print(": ");
//                System.out.println("Main Thread");
//            }
//        }
//    }

    private APSemaphore semaphore;
    MainApplication(APSemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                semaphore.aquire();
                System.out.print(i);
                System.out.print(": ");
                System.out.println("Main Thread");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("The interupt has been catched");
            }
        }
    }
}
