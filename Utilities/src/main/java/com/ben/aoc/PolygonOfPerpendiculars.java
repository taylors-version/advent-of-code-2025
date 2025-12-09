package com.ben.aoc;

import org.javatuples.Pair;

import java.util.*;

public class PolygonOfPerpendiculars {
    private final NavigableMap<Integer, List<Pair<Integer, Integer>>> verticalEdges = new TreeMap<>();
    private final NavigableMap<Integer, List<Pair<Integer, Integer>>> horizontalEdges = new TreeMap<>();
    private final Map<IntPoint, Boolean> containsCache = new HashMap<>();

    public PolygonOfPerpendiculars(List<IntPoint> vertices){
        for(int i = 0; i < vertices.size(); i++){
            IntPoint tileA = vertices.get(i);
            IntPoint tileB = vertices.get((i+1) % vertices.size());
            addEdge(tileA, tileB);
        }
    }

    private void addEdge(IntPoint a, IntPoint b){
        if(a.getX().equals(b.getX())){
            verticalEdges.computeIfAbsent(a.getX(), x -> new ArrayList<>()).add(new Pair<Integer, Integer>(Math.min(a.getY(), b.getY()), Math.max(a.getY(), b.getY())));
        }else{
            horizontalEdges.computeIfAbsent(a.getY(), y -> new ArrayList<>()).add(new Pair<Integer, Integer>(Math.min(a.getX(), b.getX()), Math.max(a.getX(), b.getX())));
        }
    }

    public boolean containsPoint(IntPoint point){
        return containsCache.computeIfAbsent(point, p -> isOnAnyEdge(p) || oddLeftCrossings(p));
    }

    public boolean containsRectangle(IntPoint a, IntPoint b){
        return verticalEdgesAreCompletelyInterior(a, b) && horizontalEdgesAreCompletelyInterior(a ,b);
    }

    private boolean isOnAnyEdge(IntPoint point) {
        return isOnVerticalEdge(point) || isOnHorizontalEdge(point);
    }

    private boolean oddLeftCrossings(IntPoint point) {
        int hitcount = 0;
        for(Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : verticalEdges.headMap(point.getX(), true).entrySet()){
            for(Pair<Integer, Integer> edge : entry.getValue()){
                if(point.getY() > edge.getValue0() && point.getY() <= edge.getValue1()){
                    hitcount++;
                }
            }
        }
        return hitcount%2!=0;
    }

    private boolean isOnVerticalEdge(IntPoint point) {
        List<Pair<Integer, Integer>> edge = verticalEdges.get(point.getX());
        for(Pair<Integer, Integer> range : edge){
            if(point.getY()<= range.getValue1() && point.getY()>=range.getValue0()){
                return true;
            }
        }
        return false;
    }

    private boolean isOnHorizontalEdge(IntPoint point) {
        List<Pair<Integer, Integer>> edge = horizontalEdges.get(point.getY());
        for(Pair<Integer, Integer> range : edge){
            if(point.getX()<= range.getValue1() && point.getX()>=range.getValue0()){
                return true;
            }
        }
        return false;
    }

    private boolean horizontalEdgesAreCompletelyInterior(IntPoint a, IntPoint b){
        int minX = Math.min(a.getX(), b.getX());
        int maxX = Math.max(a.getX(), b.getX());
        int minY = Math.min(a.getY(), b.getY());
        int maxY = Math.max(a.getY(), b.getY());
        for(List<Pair<Integer, Integer>> edges : verticalEdges.subMap(minX, false, maxX, false).values()){
            for(Pair<Integer, Integer> edge : edges){
                if(edge.getValue0() < maxY && edge.getValue1() > minY){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean verticalEdgesAreCompletelyInterior(IntPoint a, IntPoint b){
        int minX = Math.min(a.getX(), b.getX());
        int maxX = Math.max(a.getX(), b.getX());
        int minY = Math.min(a.getY(), b.getY());
        int maxY = Math.max(a.getY(), b.getY());
        for(List<Pair<Integer, Integer>> edges : horizontalEdges.subMap(minY, false, maxY, false).values()){
            for(Pair<Integer, Integer> edge : edges){
                if(edge.getValue0() < maxX && edge.getValue1() > minX){
                    return false;
                }
            }
        }
        return true;
    }
}
