package com.ben.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day2 day2 = new Day2();
    String testInput = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
            "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
            "824824821-824824827,2121212118-2121212124";

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(1227775554, day2.puzzle1(testInput));
    }

}
