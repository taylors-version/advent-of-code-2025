package com.ben.aoc;

import com.ben.aoc.collection.Collection;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.*;


public class Day8 {

    public long puzzle1(List<String> input, int connectionCount) {
        long result = 0;
        List<Point3d> boxes = new ArrayList<>();
        for(String l : input){
            boxes.add(new Point3d(l));
        }
        List<List<Point3d>> possibleCombinations = Collection.combinationsUtil(boxes, 2);
        List<Triplet<Point3d, Point3d, Double>> possiblePairings= new ArrayList<>();
        for(List<Point3d> c : possibleCombinations){
            possiblePairings.add(new Triplet<>(c.get(0), c.get(1), Point3d.distance(c.get(0), c.get(1))));
        }
        possiblePairings.sort((obj1, obj2) -> {
            return Double.compare(((Triplet<Point3d, Point3d, Double>) obj1).getValue2(), ((Triplet<Point3d, Point3d, Double>) obj2).getValue2());
        });

        List<Set<Point3d>> connections = new ArrayList<>();
        for(int i = 0; i < connectionCount; i++){
            Triplet<Point3d, Point3d, Double> pairing = possiblePairings.get(i);
            Set<Point3d> a = connections.stream()
                    .filter(s -> s.contains(pairing.getValue0()))
                    .findFirst()
                    .orElseGet(() -> {
                        Set<Point3d> h = new HashSet<>();
                        h.add(pairing.getValue0());
                        return h;
                    });
            Set<Point3d> b = connections.stream()
                    .filter(s -> s.contains(pairing.getValue1()))
                    .findFirst()
                    .orElseGet(() -> {
                        Set<Point3d> h = new HashSet<>();
                        h.add(pairing.getValue1());
                        return h;
                    });
            connections.remove(a);
            connections.remove(b);
            Set<Point3d> c = new HashSet<>();
            c.addAll(a);
            c.addAll(b);
            connections.add(c);
        }
        connections.sort(Comparator.comparingInt(Set::size));
        Collections.reverse(connections);

        return (long) connections.get(0).size() * connections.get(1).size() * connections.get(2).size();
    }

    public long puzzle2(List<String> input){
        long result = 0;
        List<Point3d> boxes = new ArrayList<>();
        for(String l : input){
            boxes.add(new Point3d(l));
        }
        List<List<Point3d>> possibleCombinations = Collection.combinationsUtil(boxes, 2);
        List<Triplet<Point3d, Point3d, Double>> possiblePairings= new ArrayList<>();
        for(List<Point3d> c : possibleCombinations){
            possiblePairings.add(new Triplet<>(c.get(0), c.get(1), Point3d.distance(c.get(0), c.get(1))));
        }
        possiblePairings.sort((obj1, obj2) -> {
            return Double.compare(((Triplet<Point3d, Point3d, Double>) obj1).getValue2(), ((Triplet<Point3d, Point3d, Double>) obj2).getValue2());
        });

        List<Set<Point3d>> connections = new ArrayList<>();

        int i = 0;
        while(!isAllConnected(connections, boxes.size())){
            Triplet<Point3d, Point3d, Double> pairing = possiblePairings.get(i);
            result = (long) pairing.getValue0().x * pairing.getValue1().x;
            Set<Point3d> a = connections.stream()
                    .filter(s -> s.contains(pairing.getValue0()))
                    .findFirst()
                    .orElseGet(() -> {
                        Set<Point3d> h = new HashSet<>();
                        h.add(pairing.getValue0());
                        return h;
                    });
            Set<Point3d> b = connections.stream()
                    .filter(s -> s.contains(pairing.getValue1()))
                    .findFirst()
                    .orElseGet(() -> {
                        Set<Point3d> h = new HashSet<>();
                        h.add(pairing.getValue1());
                        return h;
                    });
            connections.remove(a);
            connections.remove(b);
            Set<Point3d> c = new HashSet<>();
            c.addAll(a);
            c.addAll(b);
            connections.add(c);
            i++;
        }


        return result;
    }

    private boolean isAllConnected(List<Set<Point3d>> connections, int expectedSize){
        if (connections.size() != 1){
            return false;
        }
        return connections.get(0).size() == expectedSize;
    }

}
