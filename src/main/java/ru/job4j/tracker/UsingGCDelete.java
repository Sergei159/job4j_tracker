package ru.job4j.tracker;

public class UsingGCDelete implements UserAction {
    private final Output out;

    public UsingGCDelete(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "UsingGC Delete item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int countOfElements = input.askInt("enter count of items to delete:");
        for (int i = 1; i <= countOfElements; i++) {
            store.delete(i);
        }
        return true;
    }
}
