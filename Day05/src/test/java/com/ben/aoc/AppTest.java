package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day5 day5 = new Day5();
    String testInput = "3-5\n" +
            "10-14\n" +
            "16-20\n" +
            "12-18\n" +
            "\n" +
            "1\n" +
            "5\n" +
            "8\n" +
            "11\n" +
            "17\n" +
            "32";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(3, day5.puzzle1(input));
    }

    @Test
    public void TestExamplePuzzle2(){
        assertEquals(14, day5.puzzle2(input));
    }

}
