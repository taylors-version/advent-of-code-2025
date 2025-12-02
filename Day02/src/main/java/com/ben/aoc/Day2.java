package com.ben.aoc;


import com.ben.aoc.collection.Collection;

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
        long result = 0;
        String[] ranges = input.split(",");
        for(String range : ranges){
            result += sumOfInvalids2(range.split("-"));
        }

        return result;
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

    private long sumOfInvalids2(String[] range){
        long result = 0;
        for(long l = Long.parseLong(range[0]); l <= Long.parseLong(range[1]); l++){
            boolean invalid = false;
            String val = Long.toString(l);
            int valLength = val.length();

            for (int i = 1; i < valLength; i++){
                if(valLength % i == 0) {
                    List<String> split = StringUtil.splitString(val, i);
                    if (Collection.verifyAllEqual(split)){
                        invalid = true;
                    }
                }
            }
            if(invalid){
                result += l;
            }

        }
        return result;
    }


}
