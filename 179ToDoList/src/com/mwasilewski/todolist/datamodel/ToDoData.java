package com.mwasilewski.todolist.datamodel;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ToDoData {
    private static ToDoData instance = new ToDoData();
    private static String filename = "toDoListItems.txt";
    private List<ToDoItem> toDoItems;
    private DateTimeFormatter formatter;

    public static ToDoData getInstance() {
        return instance;
    }

    private ToDoData() {
        formatter = DateTimeFormatter.ofPattern("d-MMMM-y");
    }

    public List<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void setToDoItems(List<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }

    public void loadToDoItems() throws IOException {
        toDoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;
        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");
                String shortDesc = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];
                LocalDate date = LocalDate.parse(dateString, formatter);
                toDoItems.add(new ToDoItem(shortDesc,details,date));
            }

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
    public void storeToDoItems() throws IOException{
        Path path = Paths.get(filename);
        BufferedWriter bw=Files.newBufferedWriter(path);
        try {

            for(ToDoItem i: toDoItems)
            {
                List<String> l=new ArrayList<String>();
                l.add(i.getShortDescription());
                l.add(i.getDetails());
                l.add(i.getDeadline().format(formatter));
                bw.write(String.join("\t", l));
                bw.newLine();
            }

        }finally {
            if (bw != null) {
                bw.close();
            }
        }

    }
}
