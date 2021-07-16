package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book airport = new Book("\"Airport\"", 450);
        Book cleanCode = new Book("\"Clean code\"", 420);
        Book liveWithLighting = new Book("\"live with lighting\"", 350);
        Book nightWork = new Book("\"Night work\"", 430);
        Book[] books
                = {airport, cleanCode, liveWithLighting, nightWork};
        for (int i = 0; i < books.length; i++) {
            System.out.println("Name: " + books[i].getName() + ". "
                + "Number of pages: " + books[i].getNumber());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("After changing");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Name: " + books[i].getName() + ". "
                    + "Number of pages: " + books[i].getNumber());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("\"Clean code\"")) {
                System.out.println("Index of searched book is : " + i);
            }
        }
    }
}
