package MultiThreading;

import java.awt.*;
import java.util.concurrent.Semaphore;

public class ExtendedThread extends Thread {

//    private Object lock;
//    static Object staticLock;
//
//    ExtendedThread(Object lock) {
//        this.lock = lock;
//    }
//    ExtendedThread() {
//        this(Color.RED);
//    }
//
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            synchronized (this) {
//                System.out.print(i);
//                System.out.print(": ");
//                System.out.println("Extended Thread");
//            }
//        }
//    }

    volatile int i;
    private APSemaphore semaphore;

    ExtendedThread(APSemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                semaphore.aquire();
                System.out.print(i);
                System.out.print(": ");
                System.out.println("Extended Thread");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
