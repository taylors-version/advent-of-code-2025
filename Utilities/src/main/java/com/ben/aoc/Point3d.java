package com.ben.aoc;

public class Point3d {
    int x;
    int y;
    int z;

    public Point3d(String description){
        String[]split = description.split(",");
        x = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);
        z = Integer.parseInt(split[2]);
    }

    public Point3d(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static double distance(Point3d a, Point3d b){
        return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y- b.y, 2) + Math.pow(a.z-b.z, 2));
    }

    public static long manhattanDistance(Point3d a, Point3d b){
        return (long) Math.abs(a.x - b.x) + Math.abs(a.y - b.y) + Math.abs(a.z - b.z);
    }
}
