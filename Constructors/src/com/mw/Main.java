package com.mw;

public class Main {

    public static void main(String[] args) {
//        BankAccount b1 = new BankAccount();
//        b1.setBalance(0);
//        b1.setCustomerName("Maciek");
//        b1.setEmail("mw@mw.com");
//        b1.setNumber(1234);
//        b1.setPhoneNumber("121");
//        System.out.println(b1.getBalance());
//        b1.deposit(100);
//        b1.withdraw(120);
//        System.out.println(b1.getBalance());
//
//        BankAccount b2 = new BankAccount(0, 12344, "Michał", "ssds",
//                "564098");
//        System.out.println(b2.getCustomerName());
        VipCustomer v1 = new VipCustomer("A", 10, "sdf");
        System.out.println("V1: name " + v1.getName() + " limit: " + v1.getCreditLimit() + " email: " + v1.getEmail());
        VipCustomer v2 = new VipCustomer("A", 10);
        System.out.println("V2: name " + v2.getName() + " limit: " + v2.getCreditLimit() + " email: " + v2.getEmail());
        VipCustomer v3 = new VipCustomer();
        System.out.println("V3: name " + v3.getName() + " limit: " + v3.getCreditLimit() + " email: " + v3.getEmail());

    }
}
