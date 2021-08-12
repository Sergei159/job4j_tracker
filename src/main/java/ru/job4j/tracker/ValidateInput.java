package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    @Override
    public String askString(String question) {
        return in.askString(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            String rsl = in.askString(question);
            if (!isNumber(rsl)) {
                System.out.println("Please enter validate data again.");
                continue;
            }
            value = Integer.parseInt(rsl);
            invalid = false;
        } while (invalid);
        return value;
    }

    private boolean isNumber(String value) {
        boolean rsl = true;
        try {
            String str = in.askString(value);
        } catch (NumberFormatException nfe) {
            rsl = false;
        }
        return rsl;
    }
}
