package com.example;


public class Main {

    public static void main(String[] args) {
	// write your code here
        String varFour="This is private to main()";
        ScopeCheck scopeInstance=new ScopeCheck();
        System.out.println("scopeInstance varOne="+scopeInstance.getVarOne());
        System.out.println(varFour);
        scopeInstance.timesTwo();
        ScopeCheck.InnerClass innerClass=scopeInstance.new InnerClass();
        innerClass.timesTwo();
    }

}
