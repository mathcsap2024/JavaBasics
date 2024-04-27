package MultiThreading;

public class SideApplication implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            System.out.print(i);
            System.out.print(": ");
            System.out.println("Side Thread");
        }
    }
}
