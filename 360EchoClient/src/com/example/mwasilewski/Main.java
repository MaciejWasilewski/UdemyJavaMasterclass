package com.example.mwasilewski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter stringEcho = new PrintWriter(socket.getOutputStream(), true)) {
            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;
            socket.setSoTimeout(5000);
            while (true) {
                System.out.println("Enter string:");
                echoString = scanner.nextLine();
                stringEcho.println(echoString);
                if (!echoString.equals("quit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                } else {
                    break;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException s) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // write your code here
    }
}
