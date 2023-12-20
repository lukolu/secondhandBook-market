package com.atguigu.pojo;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE =4;

    private Integer pageNo;//当前页数
    private Integer pageTotal;//总页数
    private Integer pageTotalCount;//总记录数
    private Integer pageSize=PAGE_SIZE;//每页记录数
    private List<T> items;//当前页的数据
    private String url;

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo<1) pageNo=1;
        if (pageNo>pageTotal) pageNo=pageTotal;
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
