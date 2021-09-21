package ru.job4j.collection;

import java.util.Comparator;

public class DescDepComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");
        int rsl = rightArray[0].compareTo(leftArray[0]);
        return rsl == 0 ? right.compareTo(left) : rsl;
    }
}
