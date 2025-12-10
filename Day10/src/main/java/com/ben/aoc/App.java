package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day10 day10 = new Day10();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day10.puzzle1(lines));
        System.out.println("puzzle 2: " + day10.puzzle2(lines));
    }
}
