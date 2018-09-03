package com.mw;


public class LList {
    private ListItem current;
    private ListItem head;

    public LList() {
        current = null;
        head = null;
    }

    public void addItem(ListItem item) {
        if (item == null) {
            System.out.println("Item is null! Didn't added.");

        } else if (head == null) {
            head = item;
            current = item;
            System.out.println("Added first item");
        } else {
            while (true) {
                System.out.println("current: " + current + "\nItem: " + item + "\n***********************");
                if (current.compareTo(item) == 0) {
                    System.out.println("Items are the same! Didn't added.");
                    break;
                } else if (-current.compareTo(item) > 0) {
                    if (current.getNext() == null) {
                        current.setNext(item);
                        item.setPrevious(current);
                        current = item;
                        break;
                    } else if (-current.getNext().compareTo(item) < 0) {
                        current.setNext(item);
                        item.setPrevious(current);
                        current = item;
                        break;
                    } else {
                        current = current.getNext();
                    }
                } else if (current.getPrevious() == null) {
                    current.setPrevious(item);
                    item.setNext(current);
                    head = item;
                    current = item;
                } else if (-current.getPrevious().compareTo(item) > 0) {
                    current.getPrevious().setNext(item);
                    item.setPrevious(current.getPrevious());
                    item.setNext(current);
                    current.setPrevious(item);


                    current = item;
                    break;
                } else {
                    current = current.getPrevious();
                }
            }
        }
    }

    public ListItem previous() {
        if (current == null) {
            current = head;
        } else if (current.getPrevious() != null) {
            current = current.getPrevious();
        }
        return current;
    }

    public ListItem next() {
        if (current == null) {
            if (head != null) {
                current = head;
            } else {
                return null;
            }
        } else if (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public void remove() {
        if (current.getPrevious() != null && current.getNext() != null) {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            ListItem temp = current.getPrevious();
            current = null;
            current = temp;
        } else if (current.getPrevious() != null) {
            current.getPrevious().setNext(null);
            ListItem temp = current.getPrevious();
            current = null;
            current = temp;
        } else if (current != null) {
            current.getNext().setPrevious(null);
            head = current.getNext();
            current = null;
            current = head;
        }

    }

    boolean hasNext() {
        if (current != null) {
            return !(current.getNext() == null);
        } else {
            return (head != null);
        }

    }

    void reset() {
        current = null;

    }
}
