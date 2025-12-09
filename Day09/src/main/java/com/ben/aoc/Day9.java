package com.ben.aoc;

import com.ben.aoc.collection.Collection;
import org.javatuples.Triplet;

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

        return result;
    }


}
