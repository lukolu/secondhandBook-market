package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDAO {

    public int addBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public int updateBook(Book book);

    public int deleteBookById(Integer id);

    public Integer queryForPageTotalCount();//总记录数

    public List<Book> queryForItem(Integer pageNo,Integer pageSize);//当前页面记录




}
