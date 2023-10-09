package org.develop.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread{
    private final Socket clientSocket;
    private final InputStream inStr;
    private final OutputStreamWriter outStr;

    public ClientHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
        try {
            this.inStr = clientSocket.getInputStream();
            this.outStr = new OutputStreamWriter(clientSocket.getOutputStream());

            System.out.println("Client Online with IP address " + clientSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inStr));
            PrintWriter out = new PrintWriter(outStr, true);

            var clientInput = Integer.parseInt(in.readLine());

            if (clientInput%2 == 0){
                out.println("El numero " + clientInput + " es par.");
            }else {
                out.println("El numero " + clientInput + " es impar.");
            }

            clientInput = Integer.parseInt(in.readLine());

            if (clientInput%2 == 0){
                out.println("El numero " + clientInput + " es par.");
            }else {
                out.println("El numero " + clientInput + " es impar.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
   }
}
