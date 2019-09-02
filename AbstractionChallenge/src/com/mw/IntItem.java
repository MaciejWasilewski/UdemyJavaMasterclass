package com.mw;

public class IntItem extends ListItem implements Comparable<Integer>{
    private Integer value;

    public IntItem(int value) {
        super();
        this.value = value;

    }
    public IntItem(Integer value) {
        super();
        this.value = value;

    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(ListItem o) {
        if(o instanceof IntItem){
        return value.compareTo(((IntItem) o).getValue());}
        else
        {
            throw new IllegalArgumentException("You tried to compare IntItem with other ListItem!");
        }

    }

    @Override
    public int compareTo(Integer o) {
        return value.compareTo(o);
    }

    @Override
    public String toString() {
        return "IntItem: " + value;
    }
}
