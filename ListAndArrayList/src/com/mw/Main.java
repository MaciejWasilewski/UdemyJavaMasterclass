package com.mw;


import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - to print choice options");
        System.out.println("\t 1 - to print grocery list items");
        System.out.println("\t 2 - to add an item to the list");
        System.out.println("\t 3 - to modify an item in the list");
        System.out.println("\t 4 - to remove an item from the list");
        System.out.println("\t 6 - to quit the program");
    }
    public static void addItem()
    {
        System.out.println("Enter name of new item");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    public static void modifyItem()
    {
        groceryList.printGroceryList();
        System.out.println("Which item do you want to modify?");
        String current=scanner.nextLine();
//        scanner.nextLine();
        System.out.println("Enter replacement of the item");
        groceryList.modifyGroceryItem(current, scanner.nextLine());

    }
    public static void removeItem()
    {
        groceryList.printGroceryList();
        System.out.println("Which item do you want to remove?");
        String current=scanner.nextLine();
//scanner.nextLine();
        groceryList.removeGroceryItem(current);
    }
    public static void searchForItem()
    {
        System.out.println("What do you want to search for ");
        if(groceryList.findGroceryItem(scanner.nextLine())!=-1)
        {
            System.out.println("Found item");
        }
        else {
            System.out.println("Not found");
        }
    }

}
