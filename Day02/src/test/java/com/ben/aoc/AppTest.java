package com.ben.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day2 day2 = new Day2();

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(0, day2.puzzle1(null));
    }

}
