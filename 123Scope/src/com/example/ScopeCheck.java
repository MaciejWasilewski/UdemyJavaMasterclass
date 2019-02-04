package com.example;

public class ScopeCheck {
    public int publicVar=0;
    private int varOne =1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar="+publicVar+", varOne="+ varOne);
    }

    public int getVarOne() {
        return varOne;
    }
    public void timesTwo()
    {
        int varTwo=2;
        for(int i=0;i<10;i++)
        {
            System.out.println(i+" times two is "+i*varTwo);
        }
    }
    public class InnerClass{
        public int var3 =3;

        public InnerClass() {
            System.out.println("Inner class created, varOne is: "+ var3);
        }
        public void timesTwo()
        {
            System.out.println("varOne is still available here: "+varOne);
            System.out.println("You can still access it strictly: "+ScopeCheck.this.varOne);
            for(int i=0;i<10;i++)
            {
                System.out.println(i+" times two is "+i*var3);
            }
        }
    }
}
