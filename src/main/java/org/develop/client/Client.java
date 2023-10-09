package org.develop.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 3000)){

            var out = socket.getOutputStream();
            var in = socket.getInputStream();

            PrintWriter writer = new PrintWriter(out,true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            int num = 150234;


            writer.println(num);

         String res = reader.readLine();

            System.out.println("Respuesta: " + res);

            writer.println(157);

            res = reader.readLine();

            System.out.println("Respuesta: " + res);


            writer.close();
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
