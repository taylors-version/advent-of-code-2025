package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day11 day11 = new Day11();
    String testInput =  "";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();


    @Test
    public void TestExamplePuzzle1(){
        assertEquals(0, day11.puzzle1(input));
    }


    @Test
    public void TestExamplePuzzle2(){
        assertEquals(0, day11.puzzle2(input));
    }

}
