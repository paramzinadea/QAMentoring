package org.example;

public class Book {

    public String title;
    public String author;
    public Double price;

    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printDetails() {
        System.out.println("Book Title:" + title +
                            "; Book author:" + author+
                            "; Book price:" + price);
                }
}
