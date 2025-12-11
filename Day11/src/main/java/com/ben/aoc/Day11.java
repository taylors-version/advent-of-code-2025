package com.ben.aoc;

import java.util.*;


public class Day11 {

    public long puzzle1(List<String> input) {
        List<Device> devices = new ArrayList<>();
        for (String l : input){
            Device d = new Device(l);
            devices.add(d);
        }
        Device start = devices.stream().filter(d -> d.name.equals("you")).findFirst().get();
        return start.getPathsToOut(devices);
    }

    public long puzzle2(List<String> input){
        List<Device> devices = new ArrayList<>();
        for (String l : input){
            Device d = new Device(l);
            devices.add(d);
        }
        Device start = devices.stream().filter(d -> d.name.equals("svr")).findFirst().get();
        return start.getPathsToOutTracking(devices, false, false);
    }


}
