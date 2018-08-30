package com.mw;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        System.out.println(placesToVisit);
        printList(placesToVisit);
        placesToVisit.add(1, "Alice Springs");
        printList(placesToVisit);
        placesToVisit.remove(4);
        printList(placesToVisit);
        LinkedList<String> alphabeticCities = new LinkedList<String>();
        addInOrder(alphabeticCities, "Lublin");
        printList(alphabeticCities);
        addInOrder(alphabeticCities, "Krakow");
        printList(alphabeticCities);
        addInOrder(alphabeticCities, "Szczecin");
        printList(alphabeticCities);
        addInOrder(alphabeticCities, "Lublin");
        printList(alphabeticCities);
        visit(alphabeticCities);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());

        }
        System.out.println("**********************************");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                System.out.println(newCity + " is already included");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    public static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward=true;
        ListIterator<String> listIterator = cities.listIterator();
        if (!cities.isEmpty()) {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0: {
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                }
                case 1: {
                    if(!goingForward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        goingForward=true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());

                    } else {
                        System.out.println("Reached end of list");
                    }
                    break;
                }
                case 2:
                {
                    {
                        if(goingForward)
                        {
                            if(listIterator.hasPrevious())
                            {
                                listIterator.previous();
                            }
                            goingForward=false;
                        }
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now visiting " + listIterator.previous());

                        } else {
                            System.out.println("Reached beggining of list");
                        }
                        break;
                    }
                }
                case 3:
                {
                    printMenu();
                    break;
                }
            }
        }
    }
    private static void printMenu()
    {
        System.out.println("Available actions:\n" +
                "0 - quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print options\n");
    }
}
