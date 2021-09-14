package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return right.compareTo(left);
        };
        List<String> list = Arrays.asList("xxx", "xx", "xxxx", "x", "xxxxxxx");
        list.sort(comparator);
        for (String str :list) {
            System.out.println(str);
        }
    }
}
