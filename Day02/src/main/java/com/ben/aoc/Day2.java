package com.ben.aoc;


import java.util.List;

public class Day2 {

    public long puzzle1(String input) {
        long result = 0;
        String[] ranges = input.split(",");
        for(String range : ranges){
            result += sumOfInvalids(range.split("-"));
        }

        return result;
    }

    public long puzzle2(String input){
        return 0;
    }

    private long sumOfInvalids(String[] range){
        long result = 0;
        for(long l = Long.parseLong(range[0]); l <= Long.parseLong(range[1]); l++){
            String val = Long.toString(l);
            if(val.length() % 2 == 0){
                if (val.substring(0, val.length()/2).equals(val.substring(val.length()/2))){
                    result+= l;
                }
            }
        }
        return result;
    }

}
