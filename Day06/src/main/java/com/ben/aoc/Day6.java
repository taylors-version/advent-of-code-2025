package com.ben.aoc;

import java.util.ArrayList;
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
        long result = 0;
        List<Integer> opIndexes = new ArrayList<>();
        for (int i = 0; i < input.get(input.size() - 1).length(); i++){
            if(input.get(input.size()-1).charAt(i)!=' '){
                opIndexes.add(i);
            }
        }
        opIndexes.add(input.get(0).length()+1);

        for(int i = 0; i < opIndexes.size()-1; i++){
            long lineVal = getLineVal(input, opIndexes, i);
            result+=lineVal;
        }

        return result;
    }

    private static long getLineVal(List<String> input, List<Integer> opIndexes, int i) {
        int curr = opIndexes.get(i);
        int end = opIndexes.get(i +1)-1;
        char op = input.get(input.size()-1).charAt(curr);
        long lineVal = op == '+' ? 0 : 1;
        for(int j = curr; j < end; j++) {
            StringBuilder number = new StringBuilder();
            for (int k = 0; k < input.size() - 1; k++) {
                number.append(input.get(k).charAt(j));
            }
            int val = Integer.parseInt(number.toString().trim());
            if(op == '+'){
                lineVal+= val;
            }else{
                lineVal*=val;
            }
        }
        return lineVal;
    }


}
