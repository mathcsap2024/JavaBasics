package Network.TCP;

import Network.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class TCPServer extends Thread{
    ServerSocket serverSocket;
    Integer serverPort;

    HashMap<String, ChatServerListener> clients;

    public TCPServer(Integer serverPort) throws IOException {
        clients = new HashMap<>();
        this.serverPort = serverPort;
        serverSocket = new ServerSocket(serverPort);
    }

    @Override
    public void run() {
        while(true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("A client connected with Address: " + socket.getRemoteSocketAddress());
                ChatServerListener chatUser = new ChatServerListener(this, socket);
                String username = chatUser.getUsername();
                clients.put(username, chatUser);

                chatUser.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    boolean isUsernameAvailable(String username) {
        return !clients.containsKey(username);
    }

    public void sendMessage(Message message) {
        clients.get(message.getUsername()).sendMessage(message.
                getData());
    }
}
