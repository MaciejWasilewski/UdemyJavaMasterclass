package com.example;

import java.util.*;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int s = 1; s <= seatsPerRow; s++) {
                Seat seat = new Seat(row + String.format("%02d", s));
                seats.add(seat);
            }
        }
        seats.sort(Comparator.comparing(Seat::getSeatNumber));
    }

    public String getTheaterName() {
        return theaterName;
    }
public void printList()
{
    for(Seat seat: seats)
    {
        System.out.print(" "+seat.getSeatNumber());
    }
    System.out.println("\n\n");
}
    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber);
        int foundSeat=Collections.binarySearch(seats,requestSeat,null);
        System.out.println();
        if(foundSeat>=0)
        {
            return seats.get(foundSeat).reserve();
        }
        else
        {
            System.out.println("\nThere is no seat " + seatNumber);
            return false;
        }
//        for (Seat seat : seats) {
//            System.out.print(".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestSeat = seat;
//                System.out.print("\n");
//                break;
//            }
//        }
//        if (requestSeat == null) {
//            System.out.println("\nThere is no seat " + seatNumber);
//            return false;
//        }
//        return requestSeat.reserve();
    }

    //for testing purposes

    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        @Override
        public int compareTo(Seat o) {
            System.out.print(".");
            return this.seatNumber.compareTo(o.getSeatNumber());
        }

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }
        public boolean reserve()
        {
            if(reserved)
            {
                return false;
            }
            reserved=true;
            return true;
        }

        public String getSeatNumber() {
            return seatNumber;
        }
        public boolean cancel()
        {
            if(reserved)
            {
                reserved=false;
                System.out.println("Reservation of the seat "+seatNumber+" is cancelled");
                return true;
            }
            return false;
        }
    }
}
