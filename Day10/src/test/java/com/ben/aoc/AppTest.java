package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day10 day10 = new Day10();
    String testInput =  "";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(0, day10.puzzle1(input));
    }

    @Test
    public void TestExamplePuzzle2(){
        assertEquals(0, day10.puzzle2(input));
    }

}
