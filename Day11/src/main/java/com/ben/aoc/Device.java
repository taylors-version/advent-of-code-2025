package com.ben.aoc;

import org.javatuples.Triplet;

import java.util.*;

public class Device {
    static HashMap<String, Long> pathsToOut = new HashMap<>();
    static HashMap<Triplet<String, Boolean, Boolean>, Triplet<Long, Boolean, Boolean>> pathsTrackedToOut = new HashMap<>();


    String name;
    Set<String> outputs = new HashSet<>();

    public Device (String device){
        name = device.substring(0, 3);
        String[] outs = device.substring(5).split(" ");
        outputs.addAll(List.of(outs));
    }

    public long getPathsToOut(List<Device> devices){
        if(pathsToOut.containsKey(this.name)){
            return pathsToOut.get(this.name);
        }else{
            long paths = 0;
            for(String output : outputs){
                if(output.equals("out")){
                    paths++;
                }else {
                    Device device = devices.stream().filter(d -> d.name.equals(output)).findFirst().get();
                    paths += device.getPathsToOut(devices);
                }
            }
            pathsToOut.put(this.name, paths);
            return paths;

        }
    }

    public long getPathsToOutTracking(List<Device> devices, boolean fft, boolean dac){
        Triplet<String, Boolean, Boolean> key = new Triplet<>(this.name, fft, dac);
        if(pathsTrackedToOut.containsKey(key)){
            return pathsTrackedToOut.get(key).getValue0();
        }else{
            long paths = 0;
            for(String output : outputs){
                if(output.equals("out")){
                    if(fft && dac){
                        return 1L;
                    }else{
                        return 0L;
                    }
                }else {
                    Device device = devices.stream().filter(d -> d.name.equals(output)).findFirst().get();
                    boolean seenFtt = fft || output.equals("fft");
                    boolean seenDac = dac || output.equals("dac");
                    paths += device.getPathsToOutTracking(devices, seenFtt, seenDac);
                }
            }
            pathsTrackedToOut.put(key, new Triplet<>(paths, fft, dac));
            return paths;

        }
    }

    @Override
    public String toString(){
        return name;
    }
}
