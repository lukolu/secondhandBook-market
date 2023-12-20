package com.atguigu.service.impl;

import com.atguigu.dao.impl.BookDAOimpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceimpl implements BookService {

    private BookDAOimpl bookDAOimpl=new BookDAOimpl();

    @Override
    public void updateBook(Book book) {
        bookDAOimpl.updateBook(book);
    }

    @Override
    public void addBook(Book book) {
        bookDAOimpl.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAOimpl.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAOimpl.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAOimpl.queryBooks();
    }

    @Override
    public Page<Book> getPage(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();
        Integer pageTotalCount= bookDAOimpl.queryForPageTotalCount();
        Integer pageTotal=pageTotalCount%pageSize>0?pageTotalCount/pageSize+1:pageTotalCount/pageSize;
        List<Book> books = bookDAOimpl.queryForItem(pageNo, pageSize);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        page.setItems(books);
        page.setPageTotalCount(pageTotalCount);

        return page;
    }

    public Page<Book> getPageByPrice(Integer pageNo, Integer pageSize,int max,int min) {
        Page<Book> page = new Page<>();
        Integer pageTotalCount= bookDAOimpl.queryForPageTotalCountByPrice(max,min);
        Integer pageTotal=pageTotalCount%pageSize>0?pageTotalCount/pageSize+1:pageTotalCount/pageSize;
        List<Book> books = bookDAOimpl.queryForItemByPrice(pageNo, pageSize,max,min);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setItems(books);
        page.setPageTotalCount(pageTotalCount);

        return page;
    }




}
