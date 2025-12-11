package com.ben.aoc;

import org.javatuples.Pair;

import java.util.*;

public class Device {
    static HashMap<Pair<Device, Set<String>>, Integer> pathsToOut = new HashMap<>();


    String name;
    Set<String> outputs = new HashSet<>();

    public Device (String device){
        name = device.substring(0, 3);
        String[] outs = device.substring(5).split(" ");
        outputs.addAll(List.of(outs));
    }

    public int getPathstoOut(List<Device> devices){
        if(pathsToOut.containsKey(this)){
            return pathsToOut.get(this);
        }else{
            int paths = 0;
            for(String output : outputs){
                Device device = devices.stream().filter(d -> d.name.equals(output)).findFirst().get();
                paths += device.getPathstoOut(devices);
            }
            return paths;
        }
    }

    public int getPathstoOutTracking(List<Device> devices, Set<String> route){
        if(route.contains(name)){
            return 0;
        }
        if(pathsToOut.containsKey(new Pair<>(this, route))){
            if(route.contains("dac") && route.contains("fft")) {
                return pathsToOut.get(new Pair<>(this, route));
            }else{
                return 0;
            }
        }else{
            int paths = 0;
            for(String output : outputs){
                if(output.equals("out")){
                    if(route.contains("dac") && route.contains("fft")) {
                        pathsToOut.put(new Pair<>(this, route), 1);
                        return 1;
                    }else{
                        pathsToOut.put(new Pair<>(this, route), 0);
                        return 0;
                    }

                }else {
                    Device device = devices.stream().filter(d -> d.name.equals(output)).findFirst().get();
                    Set<String> newRoute = new HashSet<>(route);
                    newRoute.add(name);
                    paths += device.getPathstoOutTracking(devices, newRoute);
                    pathsToOut.put(new Pair<>(this, route), paths);
                }
            }
            return paths;
        }
    }
}
