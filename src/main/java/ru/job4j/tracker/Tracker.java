package ru.job4j.tracker;


import ru.job4j.search.Person;

import java.util.Arrays;
import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
   // private int size = 0;

    public ArrayList<Item> add(Item item) {
        item.setId(ids++);
        items.add(item);
        return items;
    }

    public Item findById(int id) {
        Item item = items.get(id - 1);
        return item;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                result.add(item);
            }
        }
        //Item[] soughtNames = new Item[size];
//        int count = 0;
//        for (int index = 0; index < size; index++) {
//           if (key.equals(items([)index).getName())) {
//               soughtNames[count] = items[index];
//               count++;
//           }
//        }
        //return Arrays.copyOf(soughtNames, count);
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
//        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
//        int index = indexOf(id);
//        boolean rsl = index != -1;
//        if (rsl) {
//            System.arraycopy(items, index + 1,
//                    items, index, size - index - 1);
//            items[size - 1] = null;
//            size--;
//        }
        return rsl;
    }
}

