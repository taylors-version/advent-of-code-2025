package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day9 day9 = new Day9();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day9.puzzle1(lines));
        System.out.println("puzzle 2: " + day9.puzzle2(lines));
    }
}
