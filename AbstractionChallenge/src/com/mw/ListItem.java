package com.mw;

public abstract class ListItem{
    private ListItem previous;
    private ListItem next;
    public ListItem() {
        this.previous = null;
        this.next = null;
    }

    public ListItem getPrevious() {
        return previous;
    }

    public ListItem getNext() {
        return next;
    }

    public void setPrevious(ListItem previous) {
        this.previous = previous;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }

    public abstract int compareTo(ListItem o);
}
