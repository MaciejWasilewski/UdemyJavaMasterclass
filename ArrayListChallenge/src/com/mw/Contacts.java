package com.mw;


public class Contacts {
    private int number;
    private String name;

    public Contacts(String name) {
        this(0, name);
    }

    public Contacts(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacts contacts = (Contacts) o;

//        if (number != contacts.number) return false;
        return name.equals(contacts.name);
    }

    @Override
    public int hashCode() {
        int result;
        result =name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\t"+name+" - "+number+"\n";
    }
}
