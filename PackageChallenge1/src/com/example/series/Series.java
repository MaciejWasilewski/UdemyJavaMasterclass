package com.example.series;

import com.sun.javaws.exceptions.InvalidArgumentException;

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
}
