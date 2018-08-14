package com.mw;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contacts;

    public MobilePhone() {
        this.contacts = new ArrayList<Contacts>();
    }

    public void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i).getName() + " - " + contacts.get(i).getNumber());
        }
    }

    public void addContact(String name, int number) {
        contacts.add(new Contacts(number, name));
    }

    public void updateContact(String contact, String update) {
        int pos = contacts.indexOf(new Contacts(contact));
        if (pos > -1) {
            contacts.get(pos).setName(update);
        } else {
            System.out.println("Contact not found");
        }
    }

    public void updateContact(String contact, int update) {
        int pos = contacts.indexOf(new Contacts(contact));
        if (pos > -1) {
            contacts.get(pos).setNumber(update);
        } else {
            System.out.println("Contact not found");
        }
    }

    public void removeContact(String contact) {
        int pos = contacts.indexOf(new Contacts(contact));
        if (pos > -1) {
            contacts.remove(pos);
        } else {
            System.out.println("Contact not found");
        }
    }
    public int searchContact(String contact){
        return contacts.indexOf(new Contacts(contact));
    }

    @Override
    public String toString() {
        return contacts.toString();
    }
}
