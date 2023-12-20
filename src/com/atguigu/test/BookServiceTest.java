package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceimpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookService bookService=new BookServiceimpl();

    @Test
    void getPage() {
        List items = bookService.getPage(1, 2).getItems();
        for (Object item : items) {
            System.out.println(item);
        }
        System.out.println(bookService.getPage(1, 4).getPageTotal());
        System.out.println(bookService.getPage(1,4).getPageTotalCount());
    }
}