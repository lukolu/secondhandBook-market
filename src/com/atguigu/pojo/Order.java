package com.atguigu.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private String order_id;
    private Date create_time;
    private BigDecimal price;
    private Integer status=0;
    private Integer userid;

    public Order() {
    }

    public Order(String order_id, Date create_time, BigDecimal price, Integer status, Integer userid) {
        this.order_id = order_id;
        this.create_time = create_time;
        this.price = price;
        this.status = status;
        this.userid = userid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", create_time=" + create_time +
                ", price=" + price +
                ", status=" + status +
                ", userid=" + userid +
                '}';
    }
}
