package com.example;

public class Series {
    public static Integer nSum(Integer n)
    {
        Integer sum=0;
        for(int i=1;i<=n;i++)
        {
            sum+=i;
        }
        return sum;
    }
    public static Integer factorial(Integer n)
    {
        Integer sum=1;
        for(int i=1;i<=n;i++)
        {
            sum*=i;
        }
        return sum;
    }

    public static Integer fibonacci(Integer n)
    {
        if(n==0)
        {
            return 0;
        }

        if(n==1)
        {
            return 1;
        }
        if(n<0)
        {
            throw new IllegalArgumentException();
        }

        return fibonacci(n-1)+fibonacci(n-2);
    }

}
