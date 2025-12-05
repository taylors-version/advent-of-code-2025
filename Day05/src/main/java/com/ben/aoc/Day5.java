package com.ben.aoc;


import java.util.ArrayList;
import java.util.List;

public class Day5 {

    public long puzzle1(List<String> input) {
        long result = 0;
        List<Range> freshRanges = new ArrayList<>();
        List<Long> ingredients = new ArrayList<>();
        for(String l : input){
            if(l.contains("-")) {
                freshRanges.add(new Range(l));
            }else if(!l.isEmpty()){
                ingredients.add(Long.parseLong(l));
            }
        }
        for(Long i: ingredients){
            for (Range r : freshRanges){
                if (r.inRange(i)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public long puzzle2(List<String> input){
        return 0;
    }


}
