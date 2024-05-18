package Network;

import java.io.PrintWriter;

public class NetworkUtils {
    public static void sendMessage(PrintWriter printWriter, String message) {
        printWriter.println(message);
        printWriter.flush();
    }
}
