package ru.job4j.stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(
                -5, 4, 5, -4, 6, 8, -6, -9
        );
        List<Integer> filterList = list.stream().filter(
                Integer -> Integer > 0
        ).collect(Collectors.toList());
        filterList.forEach(System.out::println);
    }
}