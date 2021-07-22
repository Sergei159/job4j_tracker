package ru.job4j.poly;

public class Plane implements Vechicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит");
    }

    @Override
    public void passenger(int numberOfPassenger) {
        System.out.println("There are "
                + numberOfPassenger + " passengers on the "
                    + getClass().getSimpleName());
    }
}
