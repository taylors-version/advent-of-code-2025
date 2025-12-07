package com.ben.aoc;

import java.util.*;


public class Day7 {

    public long puzzle1(List<String> input) {
        long result = 0;

        Set<Integer> beams = new HashSet<>();
        beams.add(input.get(0).indexOf('S'));
        for (int i = 2; i < input.size(); i+=2){
            String level = input.get(i);
            Set<Integer> newBeams = new HashSet<>();
            for(Integer b : beams){
                if(level.charAt(b) == '^'){
                    result++;
                    newBeams.add(b-1);
                    newBeams.add(b+1);
                }else{
                    newBeams.add(b);
                }
            }
            beams = newBeams;
        }

        return result;
    }

    public long puzzle2(List<String> input){
 Map<Integer, Long> timelines = new HashMap<>();
        timelines.put(input.get(0).indexOf('S'), 1L);
        for (int i = 2; i < input.size(); i+=2){
            String level = input.get(i);
            Map<Integer, Long> newBeams = new HashMap<>();
            for(Map.Entry<Integer, Long> beam: timelines.entrySet()){
                if(level.charAt(beam.getKey()) == '^'){
                    long beamCount = beam.getValue();
                    newBeams.merge(beam.getKey()-1, beamCount, (a,b) -> a + beamCount);
                    newBeams.merge(beam.getKey()+1, beamCount, (a,b) -> a + beamCount);
                }else{
                    newBeams.merge(beam.getKey(), beam.getValue(), (a,b) -> a + beam.getValue());
                }
            }
            timelines = newBeams;
        }
        return timelines.values().stream().mapToLong(Long::longValue).sum();
    }



}
