package com.ben.aoc;


import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class Day4 {
    static char[][] paper;

    public Day4(List<String> input){
        paper = new char[input.size()][];
        for(int i = 0; i < input.size(); i++){
            paper[i] = input.get(i).toCharArray();
        }
    }

    public long puzzle1() {
        long result = 0;
        for (int y = 0; y < paper.length; y++){
            for(int x = 0; x < paper[0].length; x++){
                if (paper[y][x] == '@' && countNeighbours(new IntPoint(x, y)) < 4){
                    result++;
                }
            }
        }

        return result;
    }

    public long puzzle2(){
        long result = 0;

        return result;
    }

    private int countNeighbours(IntPoint point){
        int neighbours = 0;
        for(Point<Integer> n : point.all8Neighbours()){
            if(isInGrid((IntPoint) n)){
                if(paper[n.getY()][n.getX()] == '@'){
                    neighbours++;
                }
            }
        }
        return neighbours;
    }

    private boolean isInGrid(IntPoint point){
        int maxX = paper[0].length - 1;
        int maxY = paper.length - 1;
        if (point.getX() < 0 || point.getX() > maxX || point.getY() < 0 || point.getY() > maxY){
            return false;
        }
        return true;
    }

}
