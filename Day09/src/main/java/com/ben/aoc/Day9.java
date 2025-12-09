package com.ben.aoc;

import com.ben.aoc.collection.Collection;
import org.javatuples.Pair;

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
        int minX = Integer.MAX_VALUE;
        Map<IntPoint, Boolean> safe = new HashMap<>();
        List<IntPoint> redTiles = new ArrayList<>();
        for(String l : input){
            String[] split = l.split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            IntPoint point = new IntPoint(x, y);
            redTiles.add(point);
            safe.put(point, true);
            minX = Math.min(minX, x);
        }
        List<Pair<IntPoint, IntPoint>> edges = new ArrayList<>();
        for(int i = 0; i < redTiles.size(); i++){
            IntPoint tileA = redTiles.get(i);
            IntPoint tileB = redTiles.get((i+1) % redTiles.size());
            edges.add(new Pair<>(tileA, tileB));
        }
        List<List<IntPoint>> combinations = Collection.combinationsUtil(redTiles, 2);
        for (List<IntPoint> pair : combinations){
            boolean valid = true;
            IntPoint a = pair.get(0);
            IntPoint b = pair.get(1);
            if(a.equals(new IntPoint(11,1))){
                int ben = 10;
            }
            long x = (Math.abs(a.getX() - b.getX())) + 1;
            long y = (Math.abs(a.getY() - b.getY())) + 1;
            for(int xTest = Math.min(a.getX(), b.getX()); xTest<= Math.max(a.getX(), b.getX()); xTest++){
                for(int yTest = Math.min(a.getY(), b.getY()); yTest<= Math.max(a.getY(), b.getY()); yTest++){
                    if(!safe.computeIfAbsent(new IntPoint(xTest, yTest), p -> isInside(p, redTiles, edges))){
                        valid = false;
                        break;
                    }
                }
            }
            if(valid) {
                long area = x * y;
                result = Math.max(result, area);
            }
        }


        return result;
    }

    private boolean isInside(IntPoint point, List<IntPoint> corners, List<Pair<IntPoint, IntPoint>> edges){
        int hitcount = 0;
        if(corners.contains(point) || edgesContainsPoint(point, edges)){
            return true;
        }else{
            int x = point.getX()-1;
            while (x >= 0){
                IntPoint test = new IntPoint(x, point.getY());
                for (Pair<IntPoint, IntPoint> edge : edges) {
                    if (edgeContainsPointNotTop(test, edge)) {
                        hitcount++;
                    }
                }
                x--;
            }
        }
        return hitcount % 2 !=0;
    }

    private boolean edgesContainsPoint(IntPoint point, List<Pair<IntPoint, IntPoint>> edges){
        int x = point.getX();
        int y = point.getY();
        for (Pair<IntPoint, IntPoint> edge : edges){
            int ax = edge.getValue0().getX();
            int ay = edge.getValue0().getY();
            int bx = edge.getValue1().getX();
            int by = edge.getValue1().getY();
            if(ax == bx){
                if (x==ax){
                    if(y>= Math.min(ay,by) && y<= Math.max(ay,by)){
                        return true;
                    }
                }
            }else{
                if (y==ay){
                    if(x>= Math.min(ax,bx) && x<= Math.max(ax,bx)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean edgeContainsPointNotTop(IntPoint point, Pair<IntPoint, IntPoint> edge){
        int x = point.getX();
        int y = point.getY();
            int ax = edge.getValue0().getX();
            int ay = edge.getValue0().getY();
            int bx = edge.getValue1().getX();
            int by = edge.getValue1().getY();
            if(ax == bx){
                if (x!=ax){
                    return false;
                }else{
                    return y >= Math.min(ay, by) && y < Math.max(ay, by);
                }
            }
            return false;
    }

    public IntPoint fillStart(List<IntPoint> edges, int minX){
        List<IntPoint> leftEdge = new ArrayList<>(edges.stream().filter(p -> p.getX().equals(minX)).toList());
        int y = (leftEdge.get(0).getY()+leftEdge.get(1).getY())/2;
        return new IntPoint(minX+1,y);
    }

    public Set<IntPoint> fill(Set<IntPoint> edges, IntPoint start){
        Set<IntPoint> filled = new HashSet<>();
        Queue<IntPoint> queue = new ArrayDeque<>();
        queue.add(start);
        while(!queue.isEmpty()){
            IntPoint point = queue.poll();
            filled.add(point);
            List<Point<Integer>> neighbours = point.allNeighbours();
            for(Point<Integer> n : neighbours){
                if(!filled.contains((IntPoint) n) && !edges.contains((IntPoint) n)){
                    queue.add((IntPoint) n);
                }
            }
        }
        return filled;
    }

    public Set<IntPoint> getEdgeTiles(List<IntPoint> redTiles){
        Set<IntPoint> safeTiles = new HashSet<>(redTiles);
        for(int i = 0; i < redTiles.size(); i++){
            IntPoint tileA = redTiles.get(i);
            IntPoint tileB = redTiles.get((i+1) % redTiles.size());
            if(Objects.equals(tileA.getY(), tileB.getY())){
                for(int x = Math.min(tileA.getX(), tileB.getX()) + 1; x < Math.max(tileA.getX(), tileB.getX()); x++){
                    IntPoint greenTile = new IntPoint(x, tileA.getY());
                    safeTiles.add(greenTile);
                }
            }else{
                for(int y = Math.min(tileA.getY(), tileB.getY()) + 1; y < Math.max(tileA.getY(), tileB.getY()); y++){
                    IntPoint greenTile = new IntPoint(tileA.getX(), y);
                    safeTiles.add(greenTile);
                }
            }
        }
        return safeTiles;
    }

}
