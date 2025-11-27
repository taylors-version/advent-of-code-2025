package com.ben.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day1 day1 = new Day1();

    @Test
    public void TestDummy(){
        assertEquals(0, day1.puzzle1(""));
    }
}
