package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.*;

public class Cart {
    private Map<Integer,CartItem> items=new LinkedHashMap<>();

    public int getTotalCount() {
        int totalCount=0;
        Set<Integer> integers = items.keySet();
        for (Integer integer : integers) {
            totalCount+=items.get(integer).getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice=new BigDecimal(0);
        Set<Integer> keys = items.keySet();
        for (Integer key : keys) {
            totalPrice=totalPrice.add(items.get(key).getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem cartItem)
    {
        CartItem cartItem1 = items.get(cartItem.getId());
        if (cartItem1==null)
        items.put(cartItem.getId(),cartItem);
        else
        {
            cartItem1.setCount(cartItem1.getCount()+1);
            cartItem1.setTotalPrice( new BigDecimal(cartItem1.getCount()).multiply(cartItem1.getPrice()) );
        }
    }

    public void deleteItem(int id)
    {
        items.remove(id);
    }

    public void clearItem() {
        items.clear();
    }

    public void changeItem(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem!=null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice( new BigDecimal(cartItem.getCount()).multiply(cartItem.getPrice()) );
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
