package ru.job4j.oop;


import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void maxIsFour() {
        Max a = new Max();
        int rsl = a.max(3, 4);
        Assert.assertEquals(rsl, 4);
    }

    @Test
    public void maxIsSix() {
        Max a = new Max();
        int rsl = a.max(6, 4, 5);
        Assert.assertEquals(rsl, 6);
    }

    @Test
    public void maxIsEight() {
        Max a = new Max();
        int rsl = a.max(6, 4, 5, 8);
        Assert.assertEquals(rsl, 8);
    }

}