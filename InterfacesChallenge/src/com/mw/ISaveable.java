package com.mw;

import java.util.ArrayList;

public interface ISaveable {
    ArrayList<String> save();
    void read(ArrayList<String> input);
}
