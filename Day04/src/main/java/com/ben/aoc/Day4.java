package com.ben.aoc;


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
        return getRemovablePaper(paper).size();
    }

    public long puzzle2(){
        long result = 0;
        char[][] newPaper = paper;
        List<IntPoint> removable = getRemovablePaper(newPaper);
        while (!removable.isEmpty()){
            result += removable.size();
            for (IntPoint p : removable){
                newPaper[p.getY()][p.getX()] = '.';
            }
            removable = getRemovablePaper(newPaper);
        }

        return result;
    }

    private List<IntPoint> getRemovablePaper(char[][] papers){
        List<IntPoint> removable = new ArrayList<>();
        for (int y = 0; y < paper.length; y++){
            for(int x = 0; x < paper[0].length; x++){
                IntPoint p = new IntPoint(x,y);
                if (paper[y][x] == '@' && countNeighbours(p) < 4){
                    removable.add(p);
                }
            }
        }
        return removable;
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
        return point.getX() >= 0 && point.getX() <= maxX && point.getY() >= 0 && point.getY() <= maxY;
    }

}
