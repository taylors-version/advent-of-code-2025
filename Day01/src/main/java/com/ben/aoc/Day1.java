package com.ben.aoc;


import org.javatuples.Pair;

import java.util.List;

public class Day1 {

    public long puzzle1(List<String> input) {
        long result = 0;
        int dialPos = 50;

        for(String l : input){
            char dir = l.charAt(0);
            int val = Integer.parseInt(l.substring(1));
            if(dir == 'R'){
                dialPos += val;
            }else{
                dialPos -= val;
            }
            if (dialPos % 100 == 0){
                result++;
            }
        }

        return result;
    }

    public long puzzle2(List<String> input){
        Pair<Integer, Integer> dial = new Pair<>(50, 0);

        for (String l : input){
            char dir = l.charAt(0);
            int val = Integer.parseInt(l.substring(1));
            dial = rotate(dial, dir, val);
        }

        return dial.getValue1();
    }

    private Pair<Integer, Integer> rotate(Pair<Integer, Integer> dial, char dir, int val){
        int pos = dial.getValue0();
        int clicks = dial.getValue1();
        if (dir == 'R') {
            int newPos = pos + val;
            return new Pair<>(newPos % 100, (newPos / 100) + clicks);
        }else{
            int newPos = pos - val;
            int zeroes = newPos > 0 ? 0 : Math.abs(newPos / 100) + 1;
            if (pos == 0){
                zeroes--;
            }
            while (newPos < 0){
                newPos+=100;
            }
            return new Pair<>(newPos, Math.abs(zeroes) + clicks);
        }
    }

}
