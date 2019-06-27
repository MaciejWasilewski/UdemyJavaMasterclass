package com.example.mwasilewski;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    private static void copyByPipe() throws IOException {
        Pipe pipe = Pipe.open();
        Runnable writer = () -> {
            Pipe.SinkChannel sinkChannel = pipe.sink();
            System.out.println(Long.BYTES);
//            Long.BYTES;
            ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
            for (int i = 0; i < 10; i++) {
                String cTime = "The time is: "+System.currentTimeMillis();
                buffer.putLong(System.currentTimeMillis());
                buffer.position(0);
                try {
                    while (buffer.hasRemaining()) {
                        sinkChannel.write(buffer);
                    }
                    buffer.position(0);
                    Thread.sleep(500);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable reader = () -> {
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer buffer = ByteBuffer.allocate(56);
            try {
                for (int i = 0; i < 10; i++) {
                    int bytesRead = sourceChannel.read(buffer);
                    byte[] timeString = new byte[bytesRead];
                    System.out.println(bytesRead);
                    buffer.position(0);

                    System.out.println(buffer.getLong());
                    buffer.position(0);
                    Thread.sleep(100);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(writer).start();
        new Thread(reader).start();

    }

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
        byteBuffer.putInt(245);
        byteBuffer.putInt(345);
        byteBuffer.putInt("Nice to meet you!".getBytes(StandardCharsets.UTF_8).length);
        byteBuffer.put("Nice to meet you!".getBytes(StandardCharsets.UTF_8));
        byteBuffer.position(0);
        binChannel.write(byteBuffer);

        binChannel.close();
        binFile.close();

        RandomAccessFile randomAccessFile = new RandomAccessFile("data.dat", "rwd");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer readBuffer = ByteBuffer.allocate(100);
        channel.read(readBuffer);
        byte[] inputString = new byte[out.length];
        readBuffer.position(0);
        readBuffer.get(inputString);
        System.out.println(new String(inputString));
        System.out.println(readBuffer.getInt());
        System.out.println(readBuffer.getInt());
        byte[] inputString2 = new byte[readBuffer.getInt()];
        readBuffer.get(inputString2);
        System.out.println(new String(inputString2));
        channel.position(0);

        RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
        FileChannel copyChannel = copyFile.getChannel();
        long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
        System.out.println(numTransferred);
        copyChannel.close();
        copyFile.close();

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
            copyByPipe();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            readWriteDat();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
