package com.ben.aoc;

import com.ben.aoc.collection.Collection;

import java.util.*;


public class Day9 {

    public long puzzle1(List<String> input) {
        long result = 0;
        List<IntPoint> tiles = new ArrayList<>();
        for(String l : input){
            String[] split = l.split(",");
            IntPoint point = new IntPoint(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            tiles.add(point);
        }
        List<List<IntPoint>> combinations = Collection.combinationsUtil(tiles, 2);
        for (List<IntPoint> pair : combinations){
            long x = (Math.abs(pair.get(0).getX() - pair.get(1).getX())) + 1;
            long y = (Math.abs(pair.get(0).getY() - pair.get(1).getY())) + 1;
            long area = x * y;
            result = Math.max(result, area);
        }
       return result;
    }

    public long puzzle2(List<String> input){
        long result = 0;
        List<IntPoint> tiles = new ArrayList<>();
        for(String l : input){
            String[] split = l.split(",");
            IntPoint point = new IntPoint(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            tiles.add(point);
        }
        PolygonOfPerpendiculars polygon = new PolygonOfPerpendiculars(tiles);
        List<List<IntPoint>> combinations = Collection.combinationsUtil(tiles, 2);
        for (List<IntPoint> pair : combinations){
            long area = computeAreaIfValid(pair.get(0), pair.get(1), polygon);
            result = Math.max(result, area);
        }

        return result;
    }

    private long computeAreaIfValid(IntPoint a, IntPoint b, PolygonOfPerpendiculars polygon){
        if(a.getX().equals(b.getX()) || a.getY().equals(b.getY())){
            return 0;
        }
        if(!polygon.containsRectangle(a,b)){
            return 0;
        }
        long x = (Math.abs(a.getX() - b.getX())) + 1;
        long y = (Math.abs(a.getY() - b.getY())) + 1;
        return x*y;
    }

}
