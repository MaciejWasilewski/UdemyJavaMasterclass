package com.example.mwasilewski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList("N42", "N36","n45", "B12", "B6", "G53", "G60");
        someBingoNumbers.forEach(n -> {
            if (n.toUpperCase().startsWith("N")) {
                System.out.println(n);
            }
        });
        someBingoNumbers
                .stream()
                .filter(n->n.toUpperCase().startsWith("N"))
                .sorted()
                .forEach(System.out::println);

        System.out.println(Stream
                .of("I29","I17","C13")
                .map(s->s.substring(1)).peek(System.out::println)
                .mapToInt(Integer::valueOf)
                .filter(i->i>15).peek(System.out::println)
                .count());
    }
}
