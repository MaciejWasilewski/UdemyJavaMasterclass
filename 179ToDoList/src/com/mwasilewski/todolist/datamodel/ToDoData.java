package com.mwasilewski.todolist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
import java.util.stream.Collectors;

public class ToDoData {
    private static ToDoData instance = new ToDoData();
    private static String filename = "toDoListItems.txt";
    private ObservableList<ToDoItem> toDoItems;
    private DateTimeFormatter formatter;

    public static ToDoData getInstance() {
        return instance;
    }

    private ToDoData() {
        formatter = DateTimeFormatter.ofPattern("d-MMMM-y");
    }

    public ObservableList<ToDoItem> getToDoItems() {
        return toDoItems;
    }


    public void loadToDoItems() throws IOException {
        System.out.println("loading");
        toDoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(path)) {

            toDoItems.
                    addAll(
                            br.lines()
                                    .map(a -> a.split("\t"))
                                    .map(a -> new ToDoItem(a[0], a[1], LocalDate.parse(a[2], formatter)))
                                    .collect(Collectors.toCollection(ArrayList::new)));
//            while ((input = br.readLine()) != null) {
//                String[] itemPieces = input.split("\t");
//                String shortDesc = itemPieces[0];
//                String details = itemPieces[1];
//                String dateString = itemPieces[2];
//                LocalDate date = LocalDate.parse(dateString, formatter);
//                toDoItems.add(new ToDoItem(shortDesc,details,date));
//            }

        }
    }
    public void storeToDoItems() throws IOException{
        Path path = Paths.get(filename);
        try(BufferedWriter bw=Files.newBufferedWriter(path))
        {
//            toDoItems
//                    .stream()
//                    .map(a->new String[]{a.getShortDescription(), a.getDetails(),a.getDeadline().format(formatter)})
//                    .forEach(a-> {
//                            bw.write(String.join("\t", a));
//                            bw.newLine();
//                        }
//                        finally {
//                            if (bw != null) {
//                                try {
//                                    bw.close();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                    });
            for(ToDoItem i: toDoItems)
            {
                List<String> l=new ArrayList<String>();
                l.add(i.getShortDescription());
                l.add(i.getDetails());
                l.add(i.getDeadline().format(formatter));
                bw.write(String.join("\t", l));
                bw.newLine();
            }
        }


    }
    public void addToDoItem(ToDoItem item)
    {
        toDoItems.add(item);
    }

    public boolean deleteItem(ToDoItem item) {
        return toDoItems.remove(item);
    }
}
