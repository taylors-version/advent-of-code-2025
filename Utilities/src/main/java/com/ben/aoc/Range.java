package com.ben.aoc;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Range implements Comparable<Range>{
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

    public boolean inRange(long val){
        return start <= val && val <= end;
    }

    public boolean isOverlap(Range r){
        boolean ben = (r.start >= start && r.start <= end) || (r.end >= start && r.end <= end);
        return (r.start >= start && r.start <= end) || (r.end >= start && r.end <= end);
    }

    public static List<Range> reduce(List<Range> ranges){
        Collections.sort(ranges);
        List<Range> reduced = new ArrayList<>();
        reduced.add(ranges.remove(0));
        for(Range r : ranges){
            boolean merged = false;
            for(int i = 0; i < reduced.size(); i++){
                Range compared = reduced.get(i);
                if(compared.isOverlap(r)){
                    Range newRange = new Range(compared.start, Math.max(r.end, compared.end));
                    reduced.set(i, newRange);
                    merged = true;
                    break;
                }
            }
            if(!merged){
                reduced.add(r);
            }
        }

        return reduced;
    }


    @Override
    public int compareTo(Range r) {
        if (start == r.start){
            return Long.compare(end, r.end);
        }
        return start < r.start ? -1 : 1;
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if(!(o instanceof Range)){
            return false;
        }
        Range r = (Range) o;
        return this.start == r.start && this.end == r.end;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.start, this.end);
    }
}
