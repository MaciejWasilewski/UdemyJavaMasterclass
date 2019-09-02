package com.example;

import java.util.*;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();
    Comparator<Seat> comp= (o1, o2) -> (int)(o1.getPrice()-o2.getPrice());

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int s = 1; s <= seatsPerRow; s++) {
                double price = 12;
                if (row < 'D' && s >= 4 && s <= 9) {
                    price = 14;
                } else if (row > 'F' || s < 4 || s > 9) {
                    price = 7;
                }
                Seat seat = new Seat(row + String.format("%02d", s), price);
                seats.add(seat);
            }
        }
        seats.sort(comp);
        printList();
        seats.sort(Comparator.comparing(Seat::getSeatNumber));

    }

    public String getTheaterName() {
        return theaterName;
    }

    public void sortList() {
        for (int i = 0; i < seats.size() - 1; i++) {
            for (int j = i + 1; j < seats.size(); j++) {
                if (seats.get(i).compareTo(seats.get(j)) > 0) {
                    Collections.swap(seats, i, j);
                }
            }
        }

    }

    public void printList() {
        for (Seat seat : seats) {
            System.out.print("\n" + seat);
        }
        System.out.println("\n\n");
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber,0);
        int foundSeat = Collections.binarySearch(seats, requestSeat, null);
        System.out.println();
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
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

    public Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        @Override
        public String toString() {
            return seatNumber + ", price: " + price;
        }

        @Override
        public int compareTo(Seat o) {
            System.out.print(".");
            return this.seatNumber.compareTo(o.getSeatNumber());
        }

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Seat seat = (Seat) o;
            return getSeatNumber().equals(seat.getSeatNumber());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getSeatNumber());
        }

        public boolean reserve() {
            if (reserved) {
                return false;
            }
            reserved = true;
            return true;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean cancel() {
            if (reserved) {
                reserved = false;
                System.out.println("Reservation of the seat " + seatNumber + " is cancelled");
                return true;
            }
            return false;
        }

        public double getPrice() {
            return price;
        }
    }
}
