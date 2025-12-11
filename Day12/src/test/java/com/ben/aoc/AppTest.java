package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day12 day12 = new Day12();
    String testInput =  "";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();


    @Test
    public void TestExamplePuzzle1(){
        assertEquals(5, day12.puzzle1(input));
    }

    @Test
    public void TestExamplePuzzle2(){
        assertEquals(2, day12.puzzle2(input));
    }

}
