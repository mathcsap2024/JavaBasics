package Network.UDP;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class RecieverApplication implements Runnable{
    Integer port = 8091;

    @Override
    public void run() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(port);

            byte[] data = new byte[10000];
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length);

            datagramSocket.receive(datagramPacket);
            System.out.println("Message received from: " + datagramPacket.getAddress());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datagramPacket.getData());
            Scanner scanner = new Scanner(byteArrayInputStream);

            String message = scanner.nextLine();
            System.out.println("The message is: " + message);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
