package com.mw;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);

    }

    public void printGroceryList() {
        System.out.println("Size of list: " + groceryList.size());
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String current,String newItem) {
        int pos = findGroceryItem(current);
        if (pos >= 0) {
            modifyGroceryItem(pos, newItem);
        }
    }

    private void modifyGroceryItem(int pos, String newItem) {
        groceryList.set(pos, newItem);
        System.out.println("Item " + pos + " has been modified.");
    }
    public void removeGroceryItem(String item)
    {
        int pos = findGroceryItem(item);
        if (pos >= 0) {
            removeGroceryItem(pos);
        }
    }

    private void removeGroceryItem(int pos) {
        String theItem = groceryList.get(pos);
        groceryList.remove(pos);
        System.out.println("Position " + theItem + " removed.");
    }

    public int findGroceryItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }
}
