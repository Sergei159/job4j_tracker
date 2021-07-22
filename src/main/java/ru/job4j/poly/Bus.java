package ru.job4j.poly;

public class Bus implements Vechicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет");
    }

    @Override
    public void passenger(int number) {
        System.out.println("There are " + number
                + " passengers on the "
                    + getClass().getSimpleName());
    }
}

