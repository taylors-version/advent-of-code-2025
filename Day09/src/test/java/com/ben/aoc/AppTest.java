package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day9 day9 = new Day9();
    String testInput =  "7,1\n" +
            "11,1\n" +
            "11,7\n" +
            "9,7\n" +
            "9,5\n" +
            "2,5\n" +
            "2,3\n" +
            "7,3\n";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(50, day9.puzzle1(input));
    }

    @Test
    public void TestExamplePuzzle2(){
        assertEquals(24, day9.puzzle2(input));
    }

}
