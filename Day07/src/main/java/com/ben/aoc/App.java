package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day7 day7 = new Day7();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day7.puzzle1(lines));
        System.out.println("puzzle 2: " + day7.puzzle2(lines));
    }
}
