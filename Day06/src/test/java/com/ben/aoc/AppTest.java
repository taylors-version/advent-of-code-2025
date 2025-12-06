package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day6 day6 = new Day6();
    String testInput = "123 328  51 64 \n" +
            " 45 64  387 23 \n" +
            "  6 98  215 314\n" +
            "*   +   *   +  ";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(4277556, day6.puzzle1(input));
    }


}
