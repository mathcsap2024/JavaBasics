package Network.TCP;

import java.io.IOException;

public class ServerApplication implements Runnable{

    @Override
    public void run() {
        try {
            TCPServer server = new TCPServer(8090);
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
