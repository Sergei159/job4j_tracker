package ru.job4j.oop;

import org.junit.Test;
import  org.junit.Assert;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void whenZeroZeroAndTwoZeroThen2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(2, 0.001));
    }

    @Test
    public void whenZeroZeroAndTenFiveThen11Dot18() {
        Point a = new Point(0, 0);
        Point b = new Point(10, 5);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(11.18, 0.001));
    }

    @Test
    public void distanceIs6dot403() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 5, 4);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(6.403, 0.001));
    }

    @Test
    public void distanceIs5Dot477() {
        Point a = new Point(5, 4, 2);
        Point b = new Point(0, 5, 4);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(5.477, 0.001));
    }
}