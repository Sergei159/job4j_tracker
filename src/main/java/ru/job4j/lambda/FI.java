package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CountedCompleter;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        Arrays.sort(atts, comparator);

        Comparator<Attachment> descComparator = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return right.getSize() - left.getSize();
        };
    }

}