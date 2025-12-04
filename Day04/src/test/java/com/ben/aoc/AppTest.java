package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    String testInput = "..@@.@@@@.\n" +
            "@@@.@.@.@@\n" +
            "@@@@@.@.@@\n" +
            "@.@@@@..@.\n" +
            "@@.@@@@.@@\n" +
            ".@@@@@@@.@\n" +
            ".@.@.@.@@@\n" +
            "@.@@@.@@@@\n" +
            ".@@@@@@@@.\n" +
            "@.@.@@@.@.";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();
    Day4 day4 = new Day4(input);

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(13, day4.puzzle1());
    }

    @Test
    public void TestExamplePuzzle2(){
        assertEquals(43, day4.puzzle2());
    }


}
