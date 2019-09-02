package com.mw;

public class Main {

    public static void main(String[] args) {
        Ford mondeo = new Ford("Mondeo", 1, 0d, 0d);
        mondeo.accelerate(1d);
        mondeo.changeGear(2);
        mondeo.steer(2.3);
    }
}
