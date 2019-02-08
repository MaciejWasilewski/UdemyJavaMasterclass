package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
public static void main(String[] args){
    Map<String,String> languages=new HashMap<>();
    languages.put("Java","java language");
    languages.put("python", "python is a programming language");
//    System.out.println(languages.get("python"));
//    System.out.println(languages.get("Python"));
    for(String s: languages.keySet())
    {
        System.out.println(languages.get(s));
    }
    languages.remove("Java");

}
}
