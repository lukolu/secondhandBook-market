package com.atguigu.dao.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.pojo.Book;

import java.math.BigDecimal;
import java.util.List;

public class BookDAOimpl extends BasicDao<Book> implements BookDAO {


    @Override
    public int addBook(Book book) {
         return update("insert into t_book values(?,?,?,?,?,?,?)", null, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(),
                book.getStock(), book.getImg_path());

    }

    @Override
    public Book queryBookById(Integer id) {
         return queryLine("select * from t_book where id =?", Book.class, id);
    }

    @Override
    public List<Book> queryBooks() {
        return queryMulti("select * from t_book",Book.class);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public int deleteBookById(Integer id) {
        return update("delete from t_book where id=?",id);
    }

    @Override
    public Integer queryForPageTotalCount() {
        Number number= (Number) queryObject("select count(*) from t_book");
        return number.intValue();
    }

    @Override
    public List<Book> queryForItem(Integer pageNo,Integer pageSize) {
        return queryMulti("select * from t_book limit ?,?",Book.class,(pageNo-1)*pageSize,pageSize);
    }

    public List<Book> queryBooksByPrice(int max,int min) {
        return queryMulti("select * from t_book where price between ? and ?",Book.class,min,max);
    }

    public Integer queryForPageTotalCountByPrice(int max,int min) {
        Number number= (Number) queryObject("select count(*) from t_book where price between ? and ?",min,max);
        return number.intValue();
    }

    public List<Book> queryForItemByPrice(Integer pageNo,Integer pageSize,int max,int min) {
        return queryMulti("select * from t_book where price between ? and ? limit ?,?",Book.class,min,max,(pageNo-1)*pageSize,pageSize);
    }


}
