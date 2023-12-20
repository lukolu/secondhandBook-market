package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {
    public void updateBook(Book book);
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public Page getPage(Integer pageNo,Integer pageSize);
}
