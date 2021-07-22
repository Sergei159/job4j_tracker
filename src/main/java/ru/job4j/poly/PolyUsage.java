package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vechicle plane = new Plane();
        Vechicle trane = new Trane();
        Vechicle bus = new Bus();

        Vechicle[] vechicles = new Vechicle[]{plane, trane, bus};
        for (Vechicle vechicle : vechicles) {
            vechicle.move();
        }
        plane.passenger(200);
        trane.passenger(120);
        bus.passenger(10);
    }
}
