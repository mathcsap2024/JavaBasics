package Network.UDP;

import Network.NetworkUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class SenderApplication implements Runnable{
    String receiverIP = "127.0.0.1";
    Integer receiverPort = 8091;
    Integer senderPort = 8090;

    @Override
    public void run() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(senderPort);

            String message = "This is a test message";

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
            NetworkUtils.sendMessage(printWriter, message);

            byte[] data = byteArrayOutputStream.toByteArray();

            DatagramPacket packet = new DatagramPacket(
                    data,
                    data.length,
                    new InetSocketAddress(receiverIP, receiverPort));

            datagramSocket.send(packet);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
