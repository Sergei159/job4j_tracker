package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAscSort1() {
        List<String> input = Arrays.asList(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        List<String> expect = Arrays.asList(
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        );
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenAscSort2() {
        List<String> input = Arrays.asList(
                "K2",
                "K2/SK1/SSK1"
        );
        List<String> expect = Arrays.asList(
                "K2",
                "K2/SK1/SSK1"
        );
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenDescSort1() {
        List<String> input = Arrays.asList(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        List<String> expect = Arrays.asList(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenDescSort2() {
        List<String> input = Arrays.asList(
                "K2/SK1",
                "K2/SK1/SSK1"
        );
        List<String> expect = Arrays.asList(
                "K2/SK1/SSK1",
                "K2/SK1"
        );
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }
}