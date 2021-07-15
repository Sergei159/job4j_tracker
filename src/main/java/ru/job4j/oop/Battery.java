package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    @SuppressWarnings("checkstyle:OperatorWrap")
    public static void main(String[] args) {
        Battery firstBattery = new Battery(65);
        Battery secondBattery = new Battery(20);
        System.out.println(
                "first : " + firstBattery.load
                        + ". second : " + secondBattery.load);
        firstBattery.exchange(secondBattery);
        System.out.println(
                "first : " + firstBattery.load
                        + ". second : " + secondBattery.load);
    }
}

