package com.example.series;


public class Series {
    public static int nSum(int n)
    {
        if(n<0)
        {
            throw new IllegalArgumentException("n should be non-negative");
        }
        else if(n==0)
        {
            return 1;
        }
        return n+nSum(n-1);
    }
    public static int factorial(int n)
    {
        if(n<0)
        {
            throw new IllegalArgumentException("n should be non-negative");
        }
        else if(n==0)
        {
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int fibonacci(int n)
    {
        if(n<0)
        {
            throw new IllegalArgumentException("n should be non-negative");
        }
        else if(n==0)
        {
            return 0;
        }
        else if(n==1)
        {
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
