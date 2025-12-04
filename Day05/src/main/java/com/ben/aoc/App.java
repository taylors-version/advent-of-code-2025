package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day5 day5 = new Day5();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day5.puzzle1(lines));
        System.out.println("puzzle 2: " + day5.puzzle2(lines));
    }
}
