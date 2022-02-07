package ru.job4j.tracker;

public class DemoUsingGC {
    /**
     * При countOfObjects = 100_000_000 возникает OutOfMemoryError
     * @param args
     */

    public static void main(String[] args) {
        int countOfObjects = 10_000_000;
        MemTracker memTracker = new MemTracker();
        for (int i = 1; i < countOfObjects; i++) {
            Item item = new Item("Name " + i);
            memTracker.add(item);
        }

    }
}
