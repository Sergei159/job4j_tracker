package ru.job4j.tracker;

public class UsingGCAdding implements UserAction {
    private final Output out;

    public UsingGCAdding(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "UsingGC Adding item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int countOfElements = input.askInt("enter count of items to add :");
        for (int i = 1; i <= countOfElements; i++) {
            Item item = new Item("Name " + i);
            store.add(item);
        }
        return true;
    }
}
