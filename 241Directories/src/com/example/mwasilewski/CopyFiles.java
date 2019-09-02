package com.example.mwasilewski;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFiles extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;

    public CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accesing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println("Rel Path= " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);

        try {
            System.out.println("Copy" + dir+" to "+copyDir);
            Files.copy(dir, copyDir, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.out.println("Cannot copy");
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("Rel Path= " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Copy " + file+" to "+copyDir);
        Files.copy(file, copyDir, StandardCopyOption.REPLACE_EXISTING);

        return FileVisitResult.CONTINUE;
    }
}
