package com.atguigu.test;

import com.atguigu.dao.impl.BookDAOimpl;
import com.atguigu.pojo.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOimplTest {
    private BookDAOimpl bookDAOimpl=new BookDAOimpl();

    @Test
    void addBook() {
//        bookDAOimpl.addBook(new Book(null,"红楼梦",123.0,"曹雪芹",100,100,"/static/img/default.jpg"));

    }

    @Test
    void queryBookById() {
        Book book = bookDAOimpl.queryBookById(21);
        System.out.println(book);
    }

    @Test
    void queryBooks() {
        List<Book> books = bookDAOimpl.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void updateBook() {
//        bookDAOimpl.updateBook(bookDAOimpl.q);
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.author = author;
//        this.sales = sales;
//        this.stock = stock;
//        this.img_path = img_path;
//        bookDAOimpl.updateBook(new Book(21,"水浒传",12.0,"康师傅",120,120,"/static/img/default.png"));
    }

    @Test
    void deleteBookById() {
        bookDAOimpl.deleteBookById(21);
    }

    @Test
    void testAddBook() {
    }

    @Test
    void testQueryBookById() {
    }

    @Test
    void testQueryBooks() {
    }

    @Test
    void testUpdateBook() {
    }

    @Test
    void testDeleteBookById() {
    }

    @Test
    void queryForPageTotalCount() {
    }

    @Test
    void queryForItem() {
    }
}