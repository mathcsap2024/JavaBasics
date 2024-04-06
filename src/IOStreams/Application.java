package IOStreams;

import java.io.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class Application implements Runnable{
    public void run() {
        InputStream inputStream;
        OutputStream outputStream;

        try {
            FileInputStream fileInputStream = new FileInputStream(new File("data.txt"));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            Scanner scanner = new Scanner(bufferedInputStream);

            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("Ali", 6);
            hashMap.put("Maryam", 16);

            hashMap.get("Ali");

            FileOutputStream fileOutputStream = new FileOutputStream(new File("data.txt"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            PrintWriter printWriter = new PrintWriter(bufferedOutputStream);
            bufferedOutputStream.flush();

            RandomAccessFile randomAccessFile = new RandomAccessFile(new File("data.txt"), "w");
            randomAccessFile.getFilePointer();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
