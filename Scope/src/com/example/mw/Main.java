package com.example.mw;

public class Main {

    public static void main(String[] args) {
        String privateVar="private main()";
        ScopeCheck scopeInstance = new ScopeCheck();
        System.out.println("privateVar: "+scopeInstance.getPrivateVar());
        System.out.println(privateVar);
    }
}
