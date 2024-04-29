package MultiThreading;

public class APSemaphore {

    private int slots;
    private final int maxSlots;
    private final Object lock;

    public APSemaphore(int maxSlots, int initialSlots) throws Exception {
        lock=slots;
        this.maxSlots=maxSlots;
        this.slots=initialSlots;

        if(initialSlots<0 || maxSlots <0) {
            throw new Exception("The initial slots or maximum slots is negative");
        }
    }

    public APSemaphore(int maxSlots) throws Exception {
        this(maxSlots, maxSlots);
    }

    public APSemaphore() throws Exception {
        this(1);
    }

    public void release() {
        synchronized (lock) {
            if (slots < maxSlots) {
                slots++;
                lock.notifyAll();
            }
        }
    }

    public void aquire() throws InterruptedException {
        synchronized (lock) {
            while (slots == 0) {
                lock.wait();
            }
            slots--;
        }
    }
}
