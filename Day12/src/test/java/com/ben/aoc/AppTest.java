package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day12 day12 = new Day12();
    String testInput =  "0:\n" +
            "###\n" +
            "##.\n" +
            "##.\n" +
            "\n" +
            "1:\n" +
            "###\n" +
            "##.\n" +
            ".##\n" +
            "\n" +
            "2:\n" +
            ".##\n" +
            "###\n" +
            "##.\n" +
            "\n" +
            "3:\n" +
            "##.\n" +
            "###\n" +
            "##.\n" +
            "\n" +
            "4:\n" +
            "###\n" +
            "#..\n" +
            "###\n" +
            "\n" +
            "5:\n" +
            "###\n" +
            ".#.\n" +
            "###\n" +
            "\n" +
            "4x4: 0 0 0 0 2 0\n" +
            "12x5: 1 0 1 0 2 2\n" +
            "12x5: 1 0 1 0 3 2";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();


    @Test
    public void TestExamplePuzzle1(){
        assertEquals(2, day12.puzzle1(input));
    }

}
