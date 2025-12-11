package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day12 day12 = new Day12();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day12.puzzle1(lines));
        System.out.println("puzzle 2: " + day12.puzzle2(lines));
    }
}
