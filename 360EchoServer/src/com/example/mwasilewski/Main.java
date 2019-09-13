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
            while (true) {
                new Thread(new Echoer(serverSocket.accept())).start();
                System.out.println("Client has connected");
                System.out.println("dupa");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
