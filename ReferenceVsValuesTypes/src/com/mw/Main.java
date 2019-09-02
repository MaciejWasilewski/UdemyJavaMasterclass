package com.mw;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int myIntValue = 10;
        int anotherIntVale = myIntValue;
        System.out.println(myIntValue);
        System.out.println(anotherIntVale);
        anotherIntVale++;
        System.out.println(myIntValue);
        System.out.println(anotherIntVale);

        int[] myIntArray = new int[5];
        int[] myAnotherIntArray = myIntArray;
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(myAnotherIntArray));
        myAnotherIntArray[0]++;
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(myAnotherIntArray));
        int[] arr2=modifyArray(myIntArray);
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(myAnotherIntArray));
        System.out.println(Arrays.toString(arr2));
        arr2[0]=3;
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(myAnotherIntArray));
        System.out.println(Arrays.toString(arr2));

    }
    private static int[] modifyArray(int[] array)
    {
        array[0]=2;
        return array;
    }
}
