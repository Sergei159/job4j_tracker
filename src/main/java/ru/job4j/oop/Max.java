package ru.job4j.oop;

public class Max {
    public  int max(int first, int second) {
        return first > second ? first : second;
    }

    public  int max(int first, int second, int third) {
        return first > max(second, third)
                ? first : max(second, third);
    }

    public  int max(int first, int second, int third, int fourth) {
        return first > max(second, third, fourth)
                ? first : max(second, third, fourth);
    }
}


