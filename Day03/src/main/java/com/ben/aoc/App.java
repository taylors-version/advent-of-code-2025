package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day3 day3 = new Day3();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day3.puzzle1(lines));
        System.out.println("puzzle 2: " + day3.puzzle2(lines));
    }
}
