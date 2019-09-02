package com.example;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StaticTest firstInstance=new StaticTest("1st instance");
        System.out.println(firstInstance.getName()+" is instance number "+StaticTest.getNumInstances());
        StaticTest secondInstance=new StaticTest("2nd instance");
        System.out.println(secondInstance.getName()+" is instance number "+StaticTest.getNumInstances());
    }
}
