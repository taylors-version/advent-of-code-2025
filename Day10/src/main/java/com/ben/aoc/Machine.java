package com.ben.aoc;

import com.ben.aoc.collection.Collection;

import java.util.*;
import java.util.stream.Collectors;

public class Machine {

    NavigableMap<Integer, Boolean> indicators = new TreeMap<>();
    List<Integer> desiredButtons = new ArrayList<>();
    List<List<Integer>> buttons = new ArrayList<>();

    public Machine(String machine){
        String[] split = machine.split(" ");
        for (int i = 1; i < split[0].length() -1; i++){
            indicators.put(i-1, split[0].charAt(i)=='#');
            if(split[0].charAt(i)=='#') {
                desiredButtons.add(i - 1);
            }
        }
        for (int i = 1; i < split.length - 1; i++){
            List<Integer> button = new ArrayList<>();
            for(int j = 1; j < split[i].length() - 1; j+=2){
                button.add(split[i].charAt(j) - '0');
            }
            buttons.add(button);
        }
    }

    public int buttonsForDesired(){
        if(buttons.contains(desiredButtons)){
            return 1;
        }

        for(int i = 2; i<20; i++){
            if(i == 3){
                int ben = 10;
            }
            List<List<List<Integer>>> combinations = Collection.combinationsUtil(buttons, i);
            for (List<List<Integer>> combo : combinations){
                if(desiredButtons.equals(resultAfterPressingButtons(combo))){
                    return i;
                }
            }
        }

        return 100;
    }

    private List<Integer> resultAfterPressingButtons(List<List<Integer>> buttonPresses){
        List<Integer> result = new ArrayList<>();
        for (List<Integer> button : buttonPresses){
            for(Integer i : button) {
                if (result.contains(i)){
                    result.remove(i);
                }else{
                    result.add(i);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public String toString(){
        StringBuilder value = new StringBuilder("[");
        for (int i = 0; i < indicators.size(); i++){
            char indicator = indicators.get(i) ? '#' : '.';
            value.append(indicator);
        }
        value.append("] ");
        for(List<Integer> button : buttons){
            value.append("(");
            value.append(button.stream().map(String::valueOf).collect(Collectors.joining(",")));
            value.append(") ");
        }
        return value.toString();
    }
}
