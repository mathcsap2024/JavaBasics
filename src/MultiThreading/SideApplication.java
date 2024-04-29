package MultiThreading;

import java.awt.*;
import java.util.concurrent.Semaphore;

public class SideApplication implements Runnable {

//    private Object lock;
//
//    SideApplication(Object lock) {
//        this.lock = lock;
//    }

//    SideApplication() {
//        this(Color.RED);
//    }

//    @Override
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            synchronized (lock) {
//                System.out.print(i);
//                System.out.print(": ");
//                System.out.println("Side Thread");
//            }
//        }
//    }
//

    APSemaphore semaphore;

    SideApplication(APSemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                semaphore.aquire();
                System.out.print(i);
                System.out.print(": ");
                System.out.println("Side Thread");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
