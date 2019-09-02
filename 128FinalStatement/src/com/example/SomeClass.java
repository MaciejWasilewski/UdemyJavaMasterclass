package com.example;

public class SomeClass {
    private static int classCounter=0;
    private final String name;
    public final int instanceNumber;

    public SomeClass(String name) {

        this.name=name;
        classCounter++;
        instanceNumber=classCounter;
        System.out.println(name+" created, instance is "+this.instanceNumber);
    }
}
