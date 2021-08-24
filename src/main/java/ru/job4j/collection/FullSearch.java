package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getNumber().equals(
                    list.get(i).getNumber())) {
                continue;
            }
            numbers.add(list.get(i - 1).getNumber());
        }
        return numbers;
    }
}
