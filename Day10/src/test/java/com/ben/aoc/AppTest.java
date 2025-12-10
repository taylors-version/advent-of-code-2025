package com.ben.aoc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Day10 day10 = new Day10();
    String testInput =  "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}\n" +
            "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}\n" +
            "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}";
    List<String>input = Arrays.stream(testInput.split("\\n")).toList();

    @Test
    public void TestMachine2Buttons(){
        Machine m = new Machine("[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}");
        assertEquals(2, m.buttonsForDesired());
    }

    @Test
    public void TestMachine3Buttons(){
        Machine m = new Machine("[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}");
        assertEquals(3, m.buttonsForDesired());
    }

    @Test
    public void TestExamplePuzzle1(){
        assertEquals(7, day10.puzzle1(input));
    }

    @Test
    public void TestExamplePuzzle2(){
        assertEquals(0, day10.puzzle2(input));
    }

}
