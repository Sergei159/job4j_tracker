package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {

    private int id;

    private String name;

    private LocalDateTime created = LocalDateTime.now();

    private DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    private String currentDateTimeFormat = created.format(formatter);

    public Item() {
    }

    public Item(String name) {
       this.name = name;
    }

    public Item(int id, String name) {
       this.id = id;
       this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getCurrentDateTimeFormat() {
        return currentDateTimeFormat;
    }

}