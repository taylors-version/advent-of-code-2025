package com.ben.aoc;

import com.ben.aoc.collection.CircularList;
import com.ben.aoc.collection.Collection;

import java.util.List;

public class Day1 {

    public long puzzle1(String input) {
        List<String> pairs = Collection.sliding(input, 2);

        long result = 0;
        for(String pair: pairs){
            if(pair.charAt(0) == pair.charAt(1)){
                result += pair.charAt(0) - '0';
            }
        }

        int loopPair = input.charAt(0) == input.charAt(input.length() - 1) ? input.charAt(0) - '0' : 0;
        return result + loopPair;
    }

    public long puzzle2(String input) {
        CircularList<Character> chars = new CircularList<>();
        for(Character c: input.toCharArray()) {
            chars.add(c);
        }
        long result = 0;
        for(int i = 0; i<chars.size(); i++){
            if (chars.get(i)==chars.getOpposite(i, true)){
                result += chars.get(i) - '0';
            }
        }


        return result ;
    }
}
