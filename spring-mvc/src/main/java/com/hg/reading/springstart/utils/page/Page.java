package com.hg.reading.springstart.utils.page;

import java.io.Serializable;

public class Page implements Serializable {

    private int total;
    private int pageSize = 6;
    private int pageCount;
    private int currentPage = 1;
    private int pageAge;
  

    // {"total":"123","pageSize":"123"....}
    public Page() {}

    public Page(int total, int pageSize, int pageCount, int currentPage) {
        this.total = total;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.currentPage = currentPage;
        
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount() {
        this.pageCount = total%pageSize==0?total/pageSize:total/pageSize+1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageAge() {
        return pageAge;
    }

    public void setPageAge() {
        this.pageAge = pageSize*(currentPage-1);
    }
}
