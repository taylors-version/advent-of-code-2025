package com.ben.aoc;


import org.javatuples.Pair;

import java.util.*;


public class Day12 {

    public long puzzle1(List<String> input) {
        long result = 0;
        Map<Integer, Parcel> parcelMap = new HashMap<>();
        List<Pair<List<Integer>, List<Integer>>> targets = new ArrayList<>();

        int shapeCount = 0;
        for(int i = 0; i < input.size(); i++){
            if(input.get(i).matches("^\\d+:")){
                Parcel p = new Parcel(input.subList(i+1, i+4));
                parcelMap.put(shapeCount++, p);
                i+=4;
            }else if(input.get(i).matches("^\\d+x\\d+:.*")){
                String[] split = input.get(i).split(":");
                List<Integer> size = new ArrayList<>();
                for(String s : split[0].split("x")){
                    size.add(Integer.parseInt(s));
                }
                List<Integer> parcels = new ArrayList<>();
                for(String s : split[1].trim().split(" ")){
                    parcels.add(Integer.parseInt(s));
                }
                targets.add(new Pair<>(size, parcels));
            }
        }

        for(Pair<List<Integer>, List<Integer>> target : targets){
            List<Integer> size = target.getValue0();
            List<Integer> parcels = target.getValue1();
            int totalSet = 0;
            for(int i = 0; i < parcels.size(); i++){
                totalSet+=(parcels.get(i) * parcelMap.get(i).countSet);
            }

            if(totalSet <= size.get(0) * size.get(1)) {
                if(fit(new boolean[size.get(0)][size.get(1)], parcelMap, parcels)){
                    result++;
                }
            }
        }

        return result;
    }

    private boolean fit(boolean[][] grid, Map<Integer, Parcel> parcelMap, List<Integer> parcels){
        boolean allZero = true;
        for(Integer parcel : parcels){
            if(parcel != 0){
                allZero = false;
                break;
            }
        }
        if(allZero){
            return true;
        }

        boolean[][] updated;
        List<Integer> parcelCopy = new ArrayList<>(parcels);
        for(int i = 0; i < parcels.size(); i++){
            if(parcels.get(i)!=0){
                Parcel p = parcelMap.get(i);
                if(p.countSet * parcels.get(i) > countFree(grid)){
                    return false;
                }

                for(int startRow = 0; startRow < grid.length-3; startRow++){
                    for(int startCol = 0; startCol < grid[0].length-3; startCol++){
                        for(int rot = 0; rot < 4; rot++){
                            for(int flip = 0; flip < 4; flip++){
                                updated = p.apply(grid, startRow, startCol, rot, (flip & 1)==1, ((flip>>1)&1)==1);
                                if(updated!=null){
                                    parcelCopy.set(i,parcelCopy.get(i)-1);
                                    return(fit(updated, parcelMap, parcelCopy));
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int countFree(boolean[][] grid) {
        int count = 0;
        for(boolean[] r : grid){
            for(boolean c : r){
                if(!c){
                    count++;
                }
            }
        }
        return count;
    }


}
