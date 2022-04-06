package ru.job4j.tracker;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class TrackerActionWithMokito {

    @Test
    public void mockitoWhenFindByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        String name = "First";
        Item item = tracker.add(new Item(name));
        FindByNameAction action =  new FindByNameAction(out);

        Input input = mock(Input.class);
        when(input.askString(any(String.class))).thenReturn(name);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Find items by name ====" + ln
                        + item + ln
        ));
        assertThat(tracker.findAll().get(0).getId(), is(1));
    }

    @Test
    public void mockitoWhenNotFoundByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("First"));
        FindByNameAction action =  new FindByNameAction(out);

        Input input = mock(Input.class);
        when(input.askString(any(String.class))).thenReturn("Second");

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Find items by name ====" + ln
                        + "Заявки с именем: Second не найдены." + ln
        ));
    }

    @Test
    public void mockitoWhenFindByID() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("First"));
        FindByIdAction action =  new FindByIdAction(out);
        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                         "=== Find item by id ====" + ln
                        + item + ln
        ));
    }

    @Test
    public void mockitoWhenNotFoundByID() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("First"));
        FindByIdAction action =  new FindByIdAction(out);
        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Find item by id ====" + ln
                        + "Заявка с введенным id: 2 не найдена." + ln
        ));
    }

    @Test
    public void mockitoWhenDeleteItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        DeleteItemAction action = new DeleteItemAction(out);
        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Delete item ====" + ln
                        + "Заявка удалена успешно." + ln));
    }

    @Test
    public void mockitoWhenNotDeletedItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        DeleteItemAction action = new DeleteItemAction(out);
        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Delete item ====" + ln
                + "Ошибка удаления заявки." + ln));
    }
}
