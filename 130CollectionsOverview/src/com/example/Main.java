package com.example;



public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Olympian", 8, 12);
        //theater.getSeats();
        if (theater.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is taken.");
        }
        if (theater.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is taken.");
        }
        theater.printList();
    }
}
