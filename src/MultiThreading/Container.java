package MultiThreading;

public class Container {
    int count;

    public synchronized int getCount() {
            return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }

    public  synchronized void reset() {
        count = 0;
    }
}
