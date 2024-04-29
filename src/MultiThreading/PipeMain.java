package MultiThreading;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PipeMain {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream=new PipedInputStream();
        PipedOutputStream pipedOutputStream=new PipedOutputStream();
        pipedOutputStream.connect(pipedInputStream);

        PrintWriter printWriter=new PrintWriter(pipedOutputStream);
        for(int i=0;i<10;i++) {
            printWriter.println(i);
        }
        printWriter.flush();

        Scanner scanner = new Scanner(pipedInputStream);
        while(scanner.hasNextInt()) {
            System.out.println(scanner.nextInt());
        }
    }
}
