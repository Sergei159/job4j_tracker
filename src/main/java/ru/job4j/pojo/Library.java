package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book airport = new Book("\"Airport\"", 450);
        Book cleanCode = new Book("\"Clean code\"", 420);
        Book liveWithLighting = new Book("\"live with lighting\"", 350);
        Book nightWork = new Book("\"Night work\"", 430);
        Book[] books
                = {airport, cleanCode, liveWithLighting, nightWork};
        for (Book book : books) {
            System.out.println("Name: " + book.getName() + ". "
                    + "Number of pages: " + book.getNumber());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("After changing");
        for (Book book : books) {
            System.out.println("Name: " + book.getName() + ". "
                    + "Number of pages: " + book.getNumber());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            if  ("\"Clean code\"".equals(books[i].getName())) {
                System.out.println("Index of searched book is : " + i);
            }
        }
    }
}
