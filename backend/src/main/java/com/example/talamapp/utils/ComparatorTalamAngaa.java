package com.example.talamapp.utils;

import com.example.talamapp.dao.MapTalamAngaaDao;

import java.util.Comparator;

public class ComparatorTalamAngaa implements Comparator<MapTalamAngaaDao> {
    @Override
    public int compare(MapTalamAngaaDao x, MapTalamAngaaDao y) {
        // TODO: Handle null x or y values
        int startComparison = compare(x.getSequence(), y.getSequence());
        return startComparison != 0 ? startComparison
                : compare(x.getSequence(), y.getSequence());
    }

    // I don't know why this isn't in Long...
    private static int compare(int a, int b) {
        return Integer.compare(a, b);
    }
}