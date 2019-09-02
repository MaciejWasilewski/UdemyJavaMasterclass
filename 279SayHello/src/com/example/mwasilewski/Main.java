package com.example.mwasilewski;

public class Main {

    public static void main(String[] args) {
        PolitePerson jane = new PolitePerson("Jane");
        PolitePerson john = new PolitePerson("John");
        new Thread(() -> jane.sayHello(john)).start();
        new Thread(() -> john.sayHello(jane)).start();


    }
}

class PolitePerson {

    private final String name;

    public PolitePerson(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    synchronized void sayHello(PolitePerson person) {
        System.out.format("%s: %s " + "has said hello to me!\n", this.name, person.getName());
        person.sayHelloBack(this);
    }

    synchronized void sayHelloBack(PolitePerson person) {
        System.out.format("%s: %s " + "has said hello back to me!\n", this.name, person.getName());
    }
}