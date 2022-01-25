package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.*;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {
    @Test
    public void whenTestFindById() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        Item result = tracker.findById(1);
        assertThat(result.getName(), is(bug.getName()));
    }

    @Test
    public void whenTestFindAll() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        List<Item> result = tracker.findAll();
        assertThat(result.get(0).getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));
    }

   @Test
    public void whenReplace() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenAscendingSortByName() {
        AscendingSortItem sort = new AscendingSortItem();
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Sergei"));
        items.add(new Item(2, "Alex"));
        items.add(new Item(3, "Andrei"));
        items.add(new Item(4, "Alexei"));
        Collections.sort(items, sort);
        List<Item> expected = new ArrayList<>(
                Arrays.asList(
                        new Item(2, "Alex"),
                        new Item(4, "Alexei"),
                        new Item(3, "Andrei"),
                        new Item(1, "Sergei")));
        assertThat(items, is(expected));
    }

    @Test
    public void whenDescendingSortByName() {
        DescendingSortItem sort = new DescendingSortItem();
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Sergei"));
        items.add(new Item(2, "Alex"));
        items.add(new Item(3, "Andrei"));
        items.add(new Item(4, "Alexei"));
        Collections.sort(items, sort);
        List<Item> expected = new ArrayList<>(
                Arrays.asList(
                        new Item(1, "Sergei"),
                        new Item(3, "Andrei"),
                        new Item(4, "Alexei"),
                        new Item(2, "Alex")));
        assertThat(items, is(expected));
    }

}