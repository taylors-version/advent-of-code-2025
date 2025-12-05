package com.ben.aoc;

public class Range {
    long start;
    long end;

    public Range(String range){
        String[] split = range.split("-");
        start = Long.parseLong(split[0]);
        end = Long.parseLong(split[1]);
    }

    public boolean inRange(long ingredient){
        return start <= ingredient && ingredient <= end;
    }
}
