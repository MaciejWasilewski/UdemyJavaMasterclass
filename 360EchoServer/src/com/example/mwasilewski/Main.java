package com.example.mwasilewski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            Socket socket = serverSocket.accept();
            System.out.println("Client has connected");
            try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {
                String echo;
                while (true) {
                    echo = input.readLine();
                    if (echo.equals("exit")) {
                        output.println("Server: good-bye!");
                        break;
                    }
                    output.println("Echo: " + echo);
                }
                output.print(input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
