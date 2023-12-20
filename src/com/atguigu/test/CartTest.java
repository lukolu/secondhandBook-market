package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void test() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"时间简史",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"时间简史",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"红楼梦",1,new BigDecimal(2000),new BigDecimal(2000)));


        cart.deleteItem(1);
        System.out.println(cart);

        cart.clearItem();
        System.out.println(cart);
    }
}