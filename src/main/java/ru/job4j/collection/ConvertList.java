package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> names = new ArrayList<>();
        for (int[] row : list) {
            for (int cell : row) {
                names.add(cell);
            }
        }
        return names;
    }
}