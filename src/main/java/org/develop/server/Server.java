package org.develop.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3000)){

            System.out.println("Server listening on port " + serverSocket.getLocalPort());

            while (true){
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
