package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day11 day11 = new Day11();
    String testInput =  "aaa: you hhh\n" +
            "you: bbb ccc\n" +
            "bbb: ddd eee\n" +
            "ccc: ddd eee fff\n" +
            "ddd: ggg\n" +
            "eee: out\n" +
            "fff: out\n" +
            "ggg: out\n" +
            "hhh: ccc fff iii\n" +
            "iii: out";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();


    @Test
    public void TestExamplePuzzle1(){
        assertEquals(5, day11.puzzle1(input));
    }

    String testInput2 =  "svr: aaa bbb\n" +
            "aaa: fft\n" +
            "fft: ccc\n" +
            "bbb: tty\n" +
            "tty: ccc\n" +
            "ccc: ddd eee\n" +
            "ddd: hub\n" +
            "hub: fff\n" +
            "eee: dac\n" +
            "dac: fff\n" +
            "fff: ggg hhh\n" +
            "ggg: out\n" +
            "hhh: out";
    List<String>input2 = Arrays.stream(testInput2.split("\\n")).toList();


    @Test
    public void TestExamplePuzzle2(){
        assertEquals(2, day11.puzzle2(input2));
    }

}
