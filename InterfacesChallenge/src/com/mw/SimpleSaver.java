package com.mw;

import java.util.ArrayList;

public class SimpleSaver implements ISaveable {
    private ArrayList<String> data=new ArrayList<String>();

    @Override
    public ArrayList<String> save() {
        return data;
    }

    @Override
    public void read(ArrayList<String> input) {
        this.data=input;
    }

    @Override
    public String toString() {
        return "SimpleSaver{" +
                "data=" + data +
                '}';
    }
}

