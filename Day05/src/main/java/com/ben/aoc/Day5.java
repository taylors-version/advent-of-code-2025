package com.ben.aoc;


import java.util.*;

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
        long result = 0;
        List<Range> freshRanges = new ArrayList<>();
        for(String l : input){
            if(l.contains("-")) {
                freshRanges.add(new Range(l));
            }
        }
        freshRanges.sort((r1, r2) -> {
            if (r1.start == r2.start) {
                if (r1.end < r2.end) return -1;
                if (r1.end > r2.end) return 1;
                return 0;
            } else {
                if (r1.start < r2.start) return -1;
            }
            return 1;
        });
        List<Range> condensed = condenseRanges(freshRanges);

        for (Range r : condensed){
            result += (r.end + 1) - r.start;
        }
        return result;
    }

    private List<Range> condenseRanges(List<Range> ranges){
        List<Range> condensed = new ArrayList<>();
        condensed.add(ranges.get(0));
        for(int i = 1; i < ranges.size(); i++){
            Range r = ranges.get(i);
            boolean merged = false;
            for (int j = 0; j < condensed.size(); j++){
                Range compared = condensed.get(j);
                if(r.start <= compared.end){
                    if(r.end >= compared.end){
                        Range newRange = new Range(compared.start, r.end);
                        condensed.set(j, newRange);
                    }
                    merged = true;
                    break;
                }
            }
            if (!merged){
                condensed.add(r);
            }
        }
        return condensed;
    }


}
