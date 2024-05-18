package Network.TCP;

import Network.NetworkUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient extends Thread{
    String serverIPAddress;
    Integer serverPort;

    Socket clientSocket;
    Scanner socketScanner;
    PrintWriter socketPrintWriter;

    Scanner consoleScanner;

    String username;

    private void initSocket() throws IOException {
        clientSocket  = new Socket(serverIPAddress,serverPort);
    }

    private void initIOStreams() throws IOException {
        socketScanner = new Scanner(clientSocket.getInputStream());
        socketPrintWriter = new PrintWriter(clientSocket.getOutputStream());
    }

    private void obtainUsername() {
        boolean isobtained = false;

        while (!isobtained) {

            String command = socketScanner.nextLine();
            System.out.println(command);

            System.out.println("Propose a username: ");
            String proposedUsername = consoleScanner.nextLine();

            socketPrintWriter.println(proposedUsername);
            socketPrintWriter.flush();

            String result = socketScanner.nextLine();
            if(result.compareTo("true") == 0) {
                username = proposedUsername;
                System.out.println("The username "+proposedUsername+" is assigned.");
                isobtained = true;
            }
            else {
                System.out.println("The username "+proposedUsername+" is not available.");
            }
        }
    }

    public TCPClient(String serverIPAddress, int serverPort) throws IOException {
        this.serverIPAddress=serverIPAddress;
        this.serverPort=serverPort;

        consoleScanner = new Scanner(System.in);
        initSocket();
        initIOStreams();

        obtainUsername();
    }

    @Override
    public void run() {
        while(clientSocket.isConnected()) {

        }
    }

    public void sendMessage(String message) {
        NetworkUtils.sendMessage(socketPrintWriter, message);
    }
}
