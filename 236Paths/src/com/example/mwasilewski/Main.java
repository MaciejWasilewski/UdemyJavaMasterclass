package com.example.mwasilewski;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

//        Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//        Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//        try {
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        sourceFile = FileSystems.getDefault().getPath("Examples", "Dir 1");
//        copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//        try {
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        Path moveFile=FileSystems.getDefault().getPath("Examples", "Dir 1","file1copy.txt");
//        sourceFile=FileSystems.getDefault().getPath("Examples", "file1copy.txt");
////        try {
////            Files.move(sourceFile,moveFile,StandardCopyOption.REPLACE_EXISTING);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        Path fileToDelete=FileSystems.getDefault().getPath("Examples", "Dir 1","file1copy.txt");
//        try {
//            System.out.println(Files.deleteIfExists(fileToDelete));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Path fileToCreate=FileSystems.getDefault().getPath("Examples", "files2.txt");
        try {
            Files.createFile(fileToCreate);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        printFile(FileSystems.getDefault().getPath("WorkingDirectory.txt"));
//        System.out.println();
//        printFile(FileSystems.getDefault().getPath("files","subdirectory.txt"));
//        System.out.println();
//        printFile(FileSystems.getDefault().getPath("..","outThere.txt"));
//        System.out.println(Paths.get(".").getParent());
//
//        Path filePath=FileSystems.getDefault().getPath("files");
//        System.out.println("Exists= "+Files.exists(filePath));
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
