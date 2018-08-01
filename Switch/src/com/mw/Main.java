package com.mw;

public class Main {

    public static void main(String[] args) {
        int value = 3;
        char val = '6';
        switch (value) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("Value was 2 or 3 or 4");
                break;
            default:
                System.out.println("Was neither 1 or 3");
                break;
        }
        switch (val) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
                System.out.println("A, B, C, D or E found.");
                break;
            default:
                System.out.println("Some other sign found.");
        }
//       apparently switch with strings works only in Java 8
//
//        String month = "Janurary";
//        switch (month) {
//            case "January":
//            case "February":
//            case "December":
//                System.out.println("It's winter");
//                break;
//            default:
//                System.out.println("It's not winter.");
//                break;
//
//        }
        printDayOfTheWeek(1);
        printDayOfTheWeek(10);


    }

    //        challenge
    public static void printDayOfTheWeek(int day) {
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
    }
}
