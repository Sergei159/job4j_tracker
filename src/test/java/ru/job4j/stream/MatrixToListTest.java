package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void whenConvertArrayToList() {
        Integer[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };

        List<Integer> expected = new ArrayList<Integer>();
        int size = Stream.of(array).mapToInt(a -> a.length).sum();
        for (int i = 1; i <= size; i++) {
            expected.add(i);
        }
        assertThat(MatrixToList.matrixToList(array), is(expected));

    }

}