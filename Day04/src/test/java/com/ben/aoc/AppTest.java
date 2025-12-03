package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day4 day4 = new Day4();
    String testInput = "";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(0, day4.puzzle1(input));
    }


}
