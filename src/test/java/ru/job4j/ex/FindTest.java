package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindTest {

    @Test
    public void whenIsRight() {
        String[] data = {"one", "two", "three"};
        String rsl = Find.get(data, 2);
        Assert.assertEquals(rsl, "three");
    }

    @Test
    public void whenAreRight() {
        String[] data = {"one", "two", "three"};
        String rsl = Find.get(data, 0);
        Assert.assertEquals(rsl, "one");
        rsl = Find.get(data, 2);
        Assert.assertEquals(rsl, "three");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIsWrong() {
        String[] data = {"one", "two", "three"};
        String rsl = Find.get(data, -1);
    }

}