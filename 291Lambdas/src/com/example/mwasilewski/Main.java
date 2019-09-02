package com.example.mwasilewski;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//	new Thread(new CodeToRun()).start();
//	new Thread(new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("Printing from the Runnable");
//        }
//    }).start();

        new Thread(() -> {
            System.out.println("Printing from lambda");
            System.out.println("Second line");
        }).start();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Maciej", 27));
        employees.add(new Employee("Maciej2", 28));
        employees.add(new Employee("AMaciej3", 29));
//        employees.sort(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        employees.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for (Employee e : employees) {
            System.out.println(e.getName());
        }
//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
        UpperConcat foo=(String s1, String s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(),
                employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);



        System.out.println(new AnotherClass().doSomething());

        employees.forEach(e-> System.out.println(e.getName()+" "+e.getAge()));
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


//class CodeToRun implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("Printing from runnable");
//    }
//}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomething(){
        System.out.println("The AnotherClass class's name is: "+getClass().getSimpleName());
        int i=0;
        return Main.doStringStuff((String s1, String s2) ->{
                    System.out.println(i);
                System.out.println("The lambda class's name is: "+getClass().getSimpleName());
                return s1.toUpperCase()+s2.toUpperCase();
            }
        ,"String1", "String2");
    }
}