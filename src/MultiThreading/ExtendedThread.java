package MultiThreading;

public class ExtendedThread extends Thread{
    public void run() {
        for(int i=0;i<1000;i++) {
            System.out.print(i);
            System.out.print(": ");
            System.out.println("Extended Thread");
        }
    }
}
