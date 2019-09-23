package com.example.mwasilewski;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;

public class Main {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            while (true) {
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                System.out.println("Text received is " + new String(buffer, 0, packet.getLength()));
                String returnString = "echo: " + new String(buffer, 0, packet.getLength());
                byte[] buffer2 = returnString.getBytes();
                packet = new DatagramPacket(buffer2, buffer2.length, packet.getAddress(), packet.getPort());
                socket.send(packet);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.getStackTrace();
        }
    }
}
