package Network.TCP;

import Network.Message;
import Network.NetworkUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerListener extends Thread{
    TCPServer server;
    Socket socket;
    String username;

    Scanner socketScanner;
    PrintWriter socketPrintWriter;

    public ChatServerListener(TCPServer server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        prepairStream();
        obtainID();
    }

    private void prepairStream() throws IOException {
        socketScanner = new Scanner(socket.getInputStream());
        socketPrintWriter = new PrintWriter(socket.getOutputStream());
    }

    private void obtainID() {
        boolean assigned = false;
        while(!assigned) {
            sendMessage("Propose your userID");
            String proposedUsername = socketScanner.nextLine();
            System.out.println("User proposed username: "+proposedUsername);
            if(server.isUsernameAvailable(proposedUsername)) {
                this.username = proposedUsername;
                System.out.println("Username " +proposedUsername + " is assigned.");
                sendMessage("true");
                assigned = true;
            }
            else {
                System.out.println("Username " +proposedUsername + " is not available.");
                sendMessage("false");
            }
        }
    }

     public String getUsername() {
         return username;
     }

     Message getMessage() {
         String destinationUsername = socketScanner.nextLine();
         String data = socketScanner.nextLine();
         return new Message(destinationUsername, data);
     }

    @Override
    public void run() {
        if(username==null) {
            throw new RuntimeException("The username is not assigned yet");
        }

        while(socket.isConnected()) {
            Message message = getMessage();
            server.sendMessage(message);
        }
    }

    public void sendMessage(String message) {
        NetworkUtils.sendMessage(socketPrintWriter, message);
    }
}
