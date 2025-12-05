package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day6 day6 = new Day6();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day6.puzzle1(lines));
        System.out.println("puzzle 2: " + day6.puzzle2(lines));
    }
}
