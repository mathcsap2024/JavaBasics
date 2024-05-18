package Network.TCP;

import java.io.IOException;

public class ClientApplication implements Runnable{
    @Override
    public void run() {
        try {
            TCPClient client = new TCPClient("127.0.0.1", 8090);
            client.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
