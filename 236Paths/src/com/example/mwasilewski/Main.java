package com.example.mwasilewski;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        printFile(FileSystems.getDefault().getPath("WorkingDirectory.txt"));
        System.out.println();
        printFile(FileSystems.getDefault().getPath("files","subdirectory.txt"));
        System.out.println();
        printFile(FileSystems.getDefault().getPath("..","outThere.txt"));
        System.out.println(Paths.get(".").getParent().getParent());
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
