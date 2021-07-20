package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] namesWithoutNull = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (items[index] != null) {
                namesWithoutNull[count] = items[index];
                count++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, count);
        return namesWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] soughtNames = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
           if (key.equals(items[index].getName())) {
               soughtNames[count] = items[index];
               count++;
           }
        }
        soughtNames = Arrays.copyOf(soughtNames, count);
        return soughtNames;
    }
}

