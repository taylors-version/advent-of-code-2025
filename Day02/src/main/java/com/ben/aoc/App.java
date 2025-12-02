package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day2 day2 = new Day2();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day2.puzzle1(lines.get(0)));
        System.out.println("puzzle 2: " + day2.puzzle2(lines.get(0)));
    }
}
