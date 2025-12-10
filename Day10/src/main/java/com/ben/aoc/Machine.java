package com.ben.aoc;

import com.ben.aoc.collection.Collection;
import com.microsoft.z3.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Machine {

    List<Integer> desiredButtons = new ArrayList<>();
    List<List<Integer>> buttons = new ArrayList<>();
    List<Integer> joltageRequirement = new ArrayList<>();

    public Machine(String machine){
        String[] split = machine.split(" ");
        for (int i = 1; i < split[0].length() -1; i++){
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
        String[] joltages = split[split.length-1].substring(1, split[split.length-1].length()-1).split(",");
        for(String j : joltages){
            joltageRequirement.add(Integer.parseInt(j));
        }
    }

    public int buttonsForIndicators(){
        if(buttons.contains(desiredButtons)){
            return 1;
        }

        for(int i = 2; i<=buttons.size(); i++){
            List<List<List<Integer>>> combinations = Collection.combinationsUtil(buttons, i);
            for (List<List<Integer>> combo : combinations){
                if(desiredButtons.equals(resultAfterPressingButtons(combo))){
                    return i;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public int buttonsForJoltage(){
        Context context = new Context();
        Optimize optimize = context.mkOptimize();
        IntExpr buttonPresses = context.mkIntConst("buttonPresses");

        IntExpr[] buttonVals = IntStream.range(0, buttons.size())
                .mapToObj(i -> context.mkIntConst("button " + i))
                .toArray(IntExpr[]::new);
        Map<Integer, List<IntExpr>> buttonsForEachPosition = new HashMap<>();

        for(int i = 0; i < buttons.size(); i++){
            IntExpr buttonVal = buttonVals[i];
            for(int pos : buttons.get(i)){
                buttonsForEachPosition.computeIfAbsent(pos, k -> new ArrayList<>()).add(buttonVal);
            }
        }

        for(Map.Entry<Integer, List<IntExpr>> entry : buttonsForEachPosition.entrySet()){
            IntExpr targetVal = context.mkInt(joltageRequirement.get(entry.getKey()));
            IntExpr[] buttonPressesArray = entry.getValue().toArray(new IntExpr[0]);
            IntExpr sumOfButtonPresses = (IntExpr) context.mkAdd(buttonPressesArray);
            BoolExpr equation = context.mkEq(targetVal, sumOfButtonPresses);
            optimize.Add(equation);
        }

        IntExpr zero = context.mkInt(0);
        for(IntExpr buttonVal : buttonVals){
            BoolExpr nonNegative = context.mkGe(buttonVal, zero);
            optimize.Add(nonNegative);
        }

        IntExpr sumOfAllButtonVals = (IntExpr) context.mkAdd(buttonVals);
        BoolExpr totalPressesEq = context.mkEq(buttonPresses, sumOfAllButtonVals);
        optimize.Add(totalPressesEq);

        optimize.MkMinimize(buttonPresses);

        Status status = optimize.Check();
        if(status == Status.SATISFIABLE){
            Model model = optimize.getModel();
            IntNum result = (IntNum) model.evaluate(buttonPresses, false);
            return result.getInt();
        }

        return Integer.MIN_VALUE;
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
        value.append(desiredButtons.stream().map(String::valueOf).collect(Collectors.joining(",")));
        value.append("] ");
        for(List<Integer> button : buttons){
            value.append("(");
            value.append(button.stream().map(String::valueOf).collect(Collectors.joining(",")));
            value.append(") ");
        }
        return value.toString();
    }
}
