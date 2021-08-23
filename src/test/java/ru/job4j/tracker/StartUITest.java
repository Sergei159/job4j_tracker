package ru.job4j.tracker;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(),
                is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        ArrayList<Item> items = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(items),
                        replacedName, "1"}
        );
        UserAction[] actions = {
                new EditItemAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
                assertThat(tracker.findById(items.size() - 1).getName(),
                is(replacedName));
//        assertThat(tracker.findById(item.getId).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        ArrayList<Item> items = tracker.add(
                new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(items.get(items.size() - 1)), "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(items.size() - 1), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();

        ArrayList<Item> items = tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
//        Item item = tracker.add(new Item("First"));
//        Item item1 = tracker.add(new Item("Second"));
        Input in = new StubInput(
                new String[]{"0", "1"}
                );
        UserAction[] actions = {
                new ShowAllAction(out), new ExitAction()
                };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all Items" + ln
                        + "1. Exit program" + ln
                        + "=== Show all items ====" + ln
                        + items.get(0) + ln
                        + items.get(1) + ln
                        + "Menu." + ln
                        + "0. Show all Items" + ln
                        + "1. Exit program" + ln
        ));
    }

     @Test
     public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        ArrayList<Item> items = tracker.add(new Item("First"));
        Input in = new StubInput(
                new String[] {"0", items.get(0).getName(), "1"}
        );
         UserAction[] actions = {
                 new FindByNameAction(out),
                 new ExitAction(),
         };
         new StartUI(out).init(in, tracker, actions);
         String ln = System.lineSeparator();
         assertThat(out.toString(), is(
                 "Menu." + ln
                         + "0. Find by name" + ln
                         + "1. Exit program" + ln
                         + "=== Find items by name ====" + ln
                         + items.get(0)
                         + ln + "Menu."
                         + ln
                         + "0. Find by name" + ln
                         + "1. Exit program" + ln
         ));
     }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        ArrayList<Item> items = tracker.add(new Item("First"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(items.get(0)), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(),
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find by Id" + ln
                        + "1. Exit program" + ln
                        + "=== Find item by id ====" + ln
                        + items.get(0)
                        + ln + "Menu."
                        + ln
                        + "0. Find by Id" + ln
                        + "1. Exit program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"9", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit program" + ln
                        + "Wrong input, you can select: 0 .. 0" +  ln
                        + "Menu." + ln
                        + "0. Exit program" + ln
                )
        );
    }
}