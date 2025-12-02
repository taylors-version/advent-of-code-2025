package com.ben.aoc;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static List<String> splitString(String text, int n) {
        List<String> results = new ArrayList<>();
        int length = text.length();

        for (int i = 0; i < length; i += n) {
            results.add(text.substring(i, Math.min(length, i + n)));
        }

        return results;
    }
}
