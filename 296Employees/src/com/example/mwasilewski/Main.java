package com.example.mwasilewski;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Maciej", 27));
        employees.add(new Employee("Maciej2", 28));
        employees.add(new Employee("AMaciej3", 31));
        employees.sort(Comparator.comparing(Employee::getName));
        employees.forEach(new Consumer2().andThen(o -> System.out.println(" " + o.getAge())));
        System.out.println("\n");

//
//        printEmployeesByAge(employees, o -> (o.getAge() > 30));
//        IntPredicate intl = i -> (i > 5);
//        IntPredicate intg = i -> i < 9;
//
//        System.out.println(intl.and(intg).test(8));
//        final Random r=new Random();
//        Supplier<Integer> s= r::nextInt;
//        System.out.println(s.get());

        Function<Employee, String> getID = e -> e.getName() + " " + e.getAge();
        System.out.println(getID.apply(employees.get(1)));

        Function<String, String> upperCase=e->e.toUpperCase();

        Function<Employee, String> chainedFunction=getID.andThen(upperCase);

        System.out.println(getID.andThen(upperCase).apply(employees.get(0)));
        BiFunction
    }

    private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> predicate) {

        employees.forEach(employee -> {
            if (predicate.test(employee)) {
                System.out.println(employee.getName());
            }
        });
    }
}

class Consumer2 implements Consumer<Employee> {
    @Override
    public void accept(Employee employee) {
        System.out.println(employee.getName() + " ");
    }
}

