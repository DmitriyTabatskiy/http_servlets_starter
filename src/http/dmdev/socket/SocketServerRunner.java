package http.dmdev.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
            System.out.println("Client request: " + inputStream.readUTF());
            outputStream.writeUTF("Hello from server!");
        }
    }
}
