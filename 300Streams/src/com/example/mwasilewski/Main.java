package com.example.mwasilewski;

import java.nio.channels.Pipe;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList("N42", "N36", "n45", "B12", "B6", "G53", "G60");
        someBingoNumbers.forEach(n -> {
            if (n.toUpperCase().startsWith("N")) {
                System.out.println(n);
            }
        });
        someBingoNumbers
                .stream()
                .filter(n -> n.toUpperCase().startsWith("N"))
                .sorted()
                .forEach(System.out::println);

        System.out.println(Stream
                .of("I29", "I17", "C13")
                .map(s -> s.substring(1)).peek(System.out::println)
                .mapToInt(Integer::valueOf)
                .filter(i -> i > 15).peek(System.out::println)
                .count());


        System.out.println("**********");
        Department department = new Department("IPPT PAN");
        department.addEmployee(new Employee("M Wasilewski", 27));
        department.addEmployee(new Employee("John Doe", 30));
        department.addEmployee(new Employee("Jan Deer", 25));

        Department accounting = new Department("Accounting");
        accounting.addEmployee(new Employee("Snow White", 22));
        List<Department> departments = new ArrayList<>();
        departments.add(department);
        departments.add(accounting);

        departments
                .stream()
                .flatMap(d -> d.getEmployees().stream())
                .forEach(System.out::println);

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupedByAge = departments
                .stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.groupingBy(e -> e.getAge()));

        departments
                .stream()
                .flatMap(d -> d.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
        departments
                .stream()
                .flatMap(d -> d.getEmployees().stream()).map(e -> e.getAge()).reduce((e1, e2) -> e1 + e2).ifPresent(System.out::println);
        //Challenge 1

        new Thread(
                () -> Stream
                        .of("Let's split this up into an array"
                                .split(" "))
                        .forEach(System.out::println)).start();
//Challenge 2
        Function<String, String> everySecondChar =
                (s) -> IntStream
                        .range(0, s.length())
                        .filter(i -> i % 2 == 1)
                        .mapToObj(s::charAt)
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString();

//        Challenge 3
        System.out.println(everySecondChar.apply("1234567890"));
//        Challenge 4
        System.out.println(everySecondChar(everySecondChar,"1234567890"));

//        Challenge 6
        Supplier<String> sup= ()->"I love Java!";
        System.out.println(sup.get());
        //List<String> topNames2015
        Stream.of("Amelia", "emily","Isla","Ava")
                .sorted(String::compareTo)
                .map(s->s.substring(0,1).toUpperCase()+s.substring(1))
                .forEach(System.out::println);
        System.out.println(Stream.of("Amelia", "emily","Isla","Ava","ave")
                .map(s->s.toLowerCase().charAt(0))
                .filter(s->s=='a')
                .map(s->1).count());
                //.reduce(0,(result, u)->++result));
    }


    static String everySecondChar(Function<String, String> f, String in)
    {
        return f.apply(in);
    }
}
