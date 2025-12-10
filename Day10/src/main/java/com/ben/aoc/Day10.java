package com.ben.aoc;

import java.util.*;


public class Day10 {

    public long puzzle1(List<String> input) {
        long result = 0;
        List<Machine> machines = new ArrayList<>();
        for (String l : input){
            machines.add(new Machine(l));
        }
        for (Machine m : machines){
            result += m.buttonsForDesired();
        }
       return result;
    }

    public long puzzle2(List<String> input){
        long result = 0;

        return result;
    }

}
