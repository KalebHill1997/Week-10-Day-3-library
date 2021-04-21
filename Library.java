package com.tts;

import java.util.ArrayList;

public class Library{
    public String address;

    public ArrayList<Book> bookList;

    public Library(String address) {
        this.address = address;
        this.bookList = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public static void printOpeningHours() {
        System.out.println("9 to 5");
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public void borrowBook(String title) {
        for(int i = 0; i <= bookList.size() - 1; i++) {
            if(bookList.get(i).getTitle().equals(title)) {
                bookList.get(i).rented();
                System.out.println("exists, borrowing now");
                System.out.println(bookList.get(i).isBorrowed());
            }
            else {
                System.out.println("does not exist, going to next element");
            }
        }
    }

    public void printAvailableBooks() {
        for(int i = 0; i <= bookList.size() - 1; i++) {
            System.out.println(bookList.get(i).getTitle());
            System.out.println("is this borrowed?: " +
                    bookList.get(i).isBorrowed());
        }
    }

    public void returnBook(String title) {
        for(int i = 0; i <= bookList.size() - 1; i++) {
            if(bookList.get(i).getTitle().equals(title)) {
                bookList.get(i).returned();
            }
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
