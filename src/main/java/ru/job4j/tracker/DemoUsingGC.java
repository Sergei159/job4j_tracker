package ru.job4j.tracker;

public class DemoUsingGC {

    public static void main(String[] args) {
        int countOfObjects = 1_000_000;
        MemTracker memTracker = new MemTracker();
        for (int i = 1; i < countOfObjects; i++) {
            Item item = new Item("Name " + i);
            memTracker.add(item);
        }
        System.out.println(memTracker.findAll());

    }
}
