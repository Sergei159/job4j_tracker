package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        int rsl = left.length() - right.length();
        for (int i = 0; i < Math.min(leftArray.length, rightArray.length); i++) {
            if (leftArray[i] != rightArray[i]) {
                rsl = leftArray[i] - rightArray[i];
                }
            }
        return rsl;
    }
}