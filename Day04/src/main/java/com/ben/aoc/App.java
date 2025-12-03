package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day4 day4 = new Day4();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day4.puzzle1(lines));
        System.out.println("puzzle 2: " + day4.puzzle2(lines));
    }
}
