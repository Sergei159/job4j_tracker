package ru.job4j.tracker;

import java.util.Scanner;

import static java.lang.System.*;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(in);

    @Override
    public String askString(String question) {
        out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        out.print(question);
        return Integer.parseInt(askString(question));
    }
}
