package com.ben.aoc;


import org.javatuples.Pair;

import java.util.List;

public class Day3 {

    public long puzzle1(List<String> input) {
        long result = 0;
        for(String bank : input){
            Pair<Character, Integer> firstMax = findMaxFromIndex(bank, 0, false);
            Pair<Character, Integer> secondMax = findMaxFromIndex(bank, firstMax.getValue1() + 1, true);
            int bankVal = (firstMax.getValue0() - '0') * 10 + (secondMax.getValue0() - '0');
            result += bankVal;
        }
        return result;
    }

    public long puzzle2(List<String> input){
        return 0;
    }

    private Pair<Character, Integer> findMaxFromIndex(String bank, int index, boolean includeEnd){
        int end = includeEnd ? bank.length() : bank.length()-1;
        char max = 0;
        int maxPos = 0;
        for(int i = index; i < end; i++){
            if(bank.charAt(i) > max){
                max = bank.charAt(i);
                maxPos = i;
            }
        }
        return new Pair<>(max, maxPos);
    }


}
