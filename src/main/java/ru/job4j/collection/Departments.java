package ru.job4j.collection;

import java.util.*;

public class Departments {

        public static List<String> fillGaps(List<String> deps) {
            Set<String> tmp = new LinkedHashSet<>();
            for (String value : deps) {
                String start = "";
                for (String el : value.split("/")) {
                    start += el;
                    tmp.add(start);
                    start += "/";
                }
            }
            return new ArrayList<>(tmp);
        }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
            Collections.sort(orgs, new DescDepComp());

    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("k1/sk1/ssk1");
        System.out.println(Departments.fillGaps(input));

    }
}