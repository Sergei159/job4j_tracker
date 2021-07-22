package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void toDrive() {
        System.out.println("Bus is moving ");
    }

    @Override
    public void passenger(int number) {
        System.out.println("There are " + number
                + "passengers in the bus ");
    }

    @Override
    public double refuel(double numberOfFuel) {
        return numberOfFuel * 49.5;
    }
}
