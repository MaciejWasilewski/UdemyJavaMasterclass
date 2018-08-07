
package com.mw;

public class Main {

    public static void main(String[] args) {
        Car ford = new Ford();
        Car unknown = new Noname();
        ford.startengine();
        unknown.startengine();
    }
}
