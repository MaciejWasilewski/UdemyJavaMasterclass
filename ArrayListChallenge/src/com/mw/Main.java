package com.mw;

import java.util.Scanner;

public class Main {
    private static MobilePhone phone=new MobilePhone();
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
	boolean quit=false;
	while(!quit)
    {
        printOptions();
        System.out.println("Enter option");
        int option=scanner.nextInt();
        scanner.nextLine();
        switch(option)
        {
            case 0:
                printOptions();
                break;
            case 1:
                listContacts();
                break;
            case 2:
                addNew();
                break;
            case 3:
                updateName();
                break;
            case 4:
                updateNumber();
                break;
            case 5:
                remove();
                break;
            case 6:
                search();
                break;
            case 7:
                quit=true;
                break;
        }
    }
    }
    public static void printOptions()
    {
        System.out.println("0 - list options");
        System.out.println("1 - list contacts");
        System.out.println("2 - add new contact");
        System.out.println("3 - update name of contact");
        System.out.println("4 - update number of contact");
        System.out.println("5 - remove contact");
        System.out.println("6 - search for contact");
        System.out.println("7 - quit");
        System.out.println();
    }
    public static void listContacts(){
        System.out.println(phone.toString());
    }
    public static void addNew()
    {
        System.out.println("Name:");

        String name=scanner.nextLine();
        System.out.println("Number: ");
        phone.addContact(name, scanner.nextInt());
        scanner.nextLine();
    }
    public static void updateName()
    {
        System.out.println("Contact: ");
        String current=scanner.nextLine();

        System.out.println("New name: ");
        phone.updateContact(current, scanner.nextLine());
    }
    public static void updateNumber()
    {
        System.out.println("Contact: ");
        String current=scanner.nextLine();

        System.out.println("New number: ");
        phone.updateContact(current, scanner.nextInt());
        scanner.nextLine();
    }
    public static void remove()
    {
        System.out.println("Contact: ");
        phone.removeContact(scanner.nextLine());
    }
    public static void search()
    {
        System.out.println("Contact: ");
        int pos=phone.searchContact(scanner.nextLine());
        if(pos>-1)
        {
            System.out.println("Contact is at position "+pos);

        }
        else
        {
            System.out.println("Contact not found");
        }
    }
}
