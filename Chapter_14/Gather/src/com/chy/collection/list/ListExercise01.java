package com.chy.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(new Book("java编程", 324, "Rose"));
        list.add(new Book("三国演义", 231, "罗贯中"));
        list.add(new Book("活着", 67, "余华"));

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (((Book) list.get(j)).getPrice() > ((Book) list.get(j + 1)).getPrice()){
                    Book temp = (Book)list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }

        //System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }


    }
}

class Book {
    private String bookName;
    private double price;
    private String author;

    public Book(String bookName, double price, String author) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
