package com.ben.aoc;


import org.javatuples.Pair;

import java.util.List;

public class Day3 {

    public long puzzle1(List<String> input) {
        long result = 0;
        for(String bank : input){
            Pair<Character, Integer> firstMax = findMaxFromIndex(bank, 0, 1);
            Pair<Character, Integer> secondMax = findMaxFromIndex(bank, firstMax.getValue1() + 1, 0);
            int bankVal = (firstMax.getValue0() - '0') * 10 + (secondMax.getValue0() - '0');
            result += bankVal;
        }
        return result;
    }

    public long puzzle2(List<String> input){
        long result = 0;
        for(String bank : input){
            int index = 0;
            long bankVal = 0;
            for(int i = 11; i >=0; i-- ){
                Pair<Character, Integer> max = findMaxFromIndex(bank, index, i);
                index = max.getValue1()+1;
                long val = (long) ((max.getValue0()-'0') * Math.pow(10, i));
                bankVal += val;
            }
            result += bankVal;
        }
        return result;
    }

    private Pair<Character, Integer> findMaxFromIndex(String bank, int index, int exclude){
        char max = 0;
        int maxPos = 0;
        for(int i = index; i < bank.length() - exclude; i++){
            if(bank.charAt(i) > max){
                max = bank.charAt(i);
                maxPos = i;
            }
        }
        return new Pair<>(max, maxPos);
    }


}
