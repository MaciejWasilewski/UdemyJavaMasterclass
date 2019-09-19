package com.example.mwasilewski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer implements Runnable {
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {
            String echo;
            while (true) {
                echo = input.readLine();
                if (echo==null || echo.equals("exit")) {
                    output.println("Server: good-bye!");
                    break;
                }
                Thread.sleep(15000);
                output.println("Echo: " + echo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("Closing connection with a socket");
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
