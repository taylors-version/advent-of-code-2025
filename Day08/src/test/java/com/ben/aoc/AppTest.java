package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day8 day8 = new Day8();
    String testInput =  "162,817,812\n" +
            "57,618,57\n" +
            "906,360,560\n" +
            "592,479,940\n" +
            "352,342,300\n" +
            "466,668,158\n" +
            "542,29,236\n" +
            "431,825,988\n" +
            "739,650,466\n" +
            "52,470,668\n" +
            "216,146,977\n" +
            "819,987,18\n" +
            "117,168,530\n" +
            "805,96,715\n" +
            "346,949,466\n" +
            "970,615,88\n" +
            "941,993,340\n" +
            "862,61,35\n" +
            "984,92,344\n" +
            "425,690,689";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(40, day8.puzzle1(input, 10));
    }

    @Test
    public void TestExamplePuzzle2(){
        assertEquals(25272, day8.puzzle2(input));
    }

}
