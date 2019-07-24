package com.example.mwasilewski;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	Message message=new Message();
	Writer writer=new Writer(message);
	Reader reader=new Reader(message);
	new Thread(writer).start();
	new Thread(reader).start();
    }
}

class Message{
    private String message;
    private boolean empty=true;

    synchronized String read(){
        while (empty)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty=true;
        notifyAll();
        return message;
    }
    synchronized void write(String message)
    {
        while (!empty)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty=false;
        this.message=message;
    }
}

class Writer implements Runnable{
private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String messages[]={
                "Maciej","Wasilewski","to ja!"
        };
        Random random=new Random();
        for (String m : messages) {
            message.write(m);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message.write("Finished!");
    }

}

class Reader implements Runnable{
private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random=new Random();
        for(String s=message.read();!s.equals("Finished!");s=message.read()) {
            System.out.println(s);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}