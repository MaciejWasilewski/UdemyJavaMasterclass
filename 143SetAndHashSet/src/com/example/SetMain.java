package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i < 101; i++) {
            squares.add((int) Math.pow(i, 2));
            cubes.add((int) Math.pow(i, 3));
        }
        System.out.println(squares.size());
        System.out.println(cubes.size());
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println(union.size());
        System.out.println(intersection.size()+"\n");
        intersection.forEach(s->System.out.println(s+"="+(int)Math.sqrt(s)+"^2="+(int)Math.cbrt(s)+"^3"));

    }
}
