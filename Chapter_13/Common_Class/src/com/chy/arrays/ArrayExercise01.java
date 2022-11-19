package com.chy.arrays;

import java.util.Comparator;

public class ArrayExercise01 {
    public static void main(String[] args) {
        //创建4本书对象
        Book[] books = new Book[4];
        books[0] = new Book("java编程", 200);
        books[1] = new Book("活着", 233);
        books[2] = new Book("钢铁是怎样炼成的", 333);
        books[3] = new Book("云边有个小卖部我好喜欢", 211);

        Book book = new Book();
        //book.bubbleSort(books, new Comparator() {
        //    @Override
        //    public int compare(Object o1, Object o2) {
        //        int price1 = (Integer) o1;
        //        int price2 = (Integer) o2;
        //        //return price1 - price2;
        //        return price2 - price1;
        //    }
        //});

        book.bubbleSortB(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int len1 = (Integer) o1;
                int len2 = (Integer) o2;
                //return price1 - price2;
                return len1 - len2;
            }
        });

        //显示书
        System.out.println("-------排序后的书-------");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }
}

class Book {
    private String name;
    private int price;

    public Book() {
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //冒泡排序方法
    public void bubbleSort(Book[] books, Comparator c) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if ((c.compare(books[j].price, books[j + 1].price)) > 0) {
                    Book temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
        }
    }

    public void bubbleSortB(Book[] books, Comparator c) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if ((c.compare(books[j].name.length(), books[j + 1].name.length())) > 0) {
                    Book temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}