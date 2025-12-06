package com.ben.aoc;

import java.util.Arrays;
import java.util.List;

public class Day6 {

    public long puzzle1(List<String> input) {
        long result = 0;
        String[][] numbers = new String[input.size() - 1][];
        for(int i = 0; i < input.size() - 1; i++){
            numbers[i] = input.get(i).trim().replaceAll(" +", " ").split(" ");
        }
        String[] ops = input.get(input.size()-1).trim().replaceAll(" +", " ").split(" ");

        for(int i = 0; i < ops.length; i++){
            long line = 0;
            if(ops[i].equals("+")){
                for (String[] number : numbers) {
                    line += Integer.parseInt(number[i]);
                }
            }else{
                line = 1;
                for (String[] number : numbers) {
                    line *= Integer.parseInt(number[i]);
                }
            }
            result+=line;
        }

        return result;
    }

    public long puzzle2(List<String> input){
        return 0;
    }


}
