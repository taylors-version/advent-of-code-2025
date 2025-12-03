package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day3 day3 = new Day3();
    String testInput = "987654321111111\n" +
            "811111111111119\n" +
            "234234234234278\n" +
            "818181911112111";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(357, day3.puzzle1(input));
    }


}
