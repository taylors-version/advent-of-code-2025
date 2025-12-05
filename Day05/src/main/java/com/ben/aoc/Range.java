package com.ben.aoc;

import java.util.HashSet;
import java.util.Set;

public class Range {
    long start;
    long end;

    public Range(String range){
        String[] split = range.split("-");
        start = Long.parseLong(split[0]);
        end = Long.parseLong(split[1]);
    }
    public Range(long start, long end){
        this.start = start;
        this.end = end;
    }

    public boolean inRange(long ingredient){
        return start <= ingredient && ingredient <= end;
    }

    public Set<Long> getFresh(){
        Set<Long> fresh = new HashSet<>();
        for (long i = start; i <= end; i ++){
            fresh.add(i);
        }
        return fresh;
    }
}
