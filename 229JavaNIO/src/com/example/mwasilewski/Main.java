package com.example.mwasilewski;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void readWriteTxt() throws IOException {

//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();
        Path dataPath = FileSystems.getDefault().getPath("data.txt");
        Files.write(dataPath, "\nLine 4".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        List<String> lines = Files.readAllLines(dataPath);
        for (String s : lines) {
            System.out.println(s);
        }

    }

    public static void readWriteDat() throws IOException {

        FileOutputStream binFile = new FileOutputStream("data.dat");
        FileChannel binChannel = binFile.getChannel();
        byte[] out = "Hello World!".getBytes(StandardCharsets.UTF_8);
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.position(0);
        byteBuffer.put(out);
//        ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
        byteBuffer.putInt(245);
//        intBuffer.flip();
//        System.out.println(binChannel.write(intBuffer));
//        intBuffer.flip();
        byteBuffer.putInt(345);
        byteBuffer.putInt("Nice to meet you!".getBytes(StandardCharsets.UTF_8).length);
        byteBuffer.put("Nice to meet you!".getBytes(StandardCharsets.UTF_8));
        byteBuffer.position(0);
//        intBuffer.flip();
//        System.out.println(binChannel.write(intBuffer));
        binChannel.write(byteBuffer);

        binChannel.close();
        binFile.close();



//        RandomAccessFile randomAccessFile=new RandomAccessFile("data.dat","rwd");
//        byte[] b=new byte[out.length];
//        randomAccessFile.read(b);
//        System.out.println(new String(b));
//        randomAccessFile.seek(out.length);
//        System.out.println(randomAccessFile.readInt());
//        randomAccessFile.seek(out.length+Integer.BYTES);
//        System.out.println(randomAccessFile.readInt());

        RandomAccessFile randomAccessFile=new RandomAccessFile("data.dat","rwd");
        FileChannel channel= randomAccessFile.getChannel();
        ByteBuffer readBuffer=ByteBuffer.allocate(100);
        channel.read(readBuffer);
        byte[] inputString=new byte[out.length];
        readBuffer.position(0);
        readBuffer.get(inputString);
        System.out.println(new String(inputString));
        System.out.println(readBuffer.getInt());
        System.out.println(readBuffer.getInt());
        byte[] inputString2=new byte[readBuffer.getInt()];
        readBuffer.get(inputString2);
        System.out.println(new String(inputString2));

        channel.close();
        randomAccessFile.close();
//        byteBuffer.flip();
//        long numBytesread=channel.read(byteBuffer);
//        System.out.println(new String(byteBuffer.array()));
//        intBuffer.position(0);
//        channel.read(intBuffer);
//        intBuffer.position(0);
//        System.out.println(intBuffer.asIntBuffer().get());
//        intBuffer.position(0);
//        channel.read(intBuffer);
//        intBuffer.position(0);
//        System.out.println(intBuffer.asIntBuffer().get());

//        channel.close();
//        randomAccessFile.close();
    }

    public static void main(String[] args) {
        try {
            readWriteDat();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
