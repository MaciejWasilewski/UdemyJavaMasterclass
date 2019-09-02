package com.example.mwasilewski;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        Path directory= FileSystems.getDefault().getPath("FileTree", "Dir2");
        try(DirectoryStream<Path> contents= Files.newDirectoryStream(directory, entry -> Files.isRegularFile(entry)))
        {
            for(Path p:contents)
            {
                System.out.println(p.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

        try{
            Path tempFile=Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file path = "+tempFile.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Walking three for Dir 2");
        Path dir2Path=FileSystems.getDefault().getPath("FileTree", "Dir2");
        try {
            Files.walkFileTree(dir2Path,new PrintNames());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Copy Dir2 to Dir4/Dir2Copy");
        Path copyPath=FileSystems.getDefault().getPath("FileTree","Dir4","Dir2Copy");
        try {
            Files.walkFileTree(dir2Path,new CopyFiles(dir2Path,copyPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
