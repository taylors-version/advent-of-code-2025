package com.ben.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day3 day3 = new Day3();
    String testInput = "";

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(0, day3.puzzle1(testInput));
    }


}
