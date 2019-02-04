package com.example;

import java.util.Scanner;

public class Main {
    static Integer x;
    public static Integer returnX(){
        return x;
    }

    public static void setX(Integer x) {
        Main.x = x;
    }

    public static Integer inputX()
    {
        Scanner x=new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter the integer:");
            if(x.hasNextInt())
            {
                break;
            }
            x.next();

        }
        return x.nextInt();
    }

    public static void main(String[] args) {
        setX(inputX());
        for(int x=1;x<13;x++)
        {
            System.out.println(returnX()*x);
        }
    }
}
