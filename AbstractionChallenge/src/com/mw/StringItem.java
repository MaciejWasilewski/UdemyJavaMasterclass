package com.mw;


public class StringItem extends ListItem implements Comparable<String> {
    private String value;

    public StringItem(String value) {
        super();
        this.value = value;

    }


    @Override
    public int compareTo(String o) {
        return value.compareTo(o);
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(ListItem o) {
        if (o instanceof StringItem) {
            return value.compareTo(((StringItem) o).getValue());
        } else {
            throw new IllegalArgumentException("You tried to compare StringItem with other ListItem!");
        }

    }

    @Override
    public String toString() {
        return "IntItem: " + value;
    }
}
