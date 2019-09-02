package com.mw;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(true, "xpc", "canon");
        printer.fillToner(1.1);
        printer.fillToner(0.5);
        printer.print(10);
    }
}
