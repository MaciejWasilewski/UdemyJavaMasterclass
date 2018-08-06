package com.mw;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("220B", "Dell", "240", dimensions);
        Monitor monitor = new Monitor("27inch Beast", "acer", 27, new Resolution(2540, 1440));
        Motherboard motherboard=new Motherboard("BJ", "acer",4,6,"v2.4");
        PC pc=new PC(theCase, monitor,motherboard);
        pc.getMonitor().drawPixelAt(10,10,"red");
        pc.getMotherboard().loadProgram("IntelliJ Idea");
    }
}
