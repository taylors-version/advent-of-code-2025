package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day1 day1 = new Day1();

    @Test
    public void TestExamplePuzzle1(){
        List<String> input = Arrays.asList("L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82");
        assertEquals(3, day1.puzzle1(input));
    }
    @Test
    public void TestExamplePuzzle2(){
        List<String> input = Arrays.asList("L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82");
        assertEquals(6, day1.puzzle2(input));
    }

}
