package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day11 day11 = new Day11();
        List<String> lines = Util.readFile(App.class, "input.txt");
        //System.out.println("puzzle 1: " + day11.puzzle1(lines));
        System.out.println("puzzle 2: " + day11.puzzle2(lines));
    }
}
