package com.newlyfly.crm.util;

/**
 * Created by llf in 11:54 2017/9/29
 */
public class PageBean {
    //当前页数
    private Integer currentPage;
    //每页显示条数
    private Integer pageSize;
    //总页数
    private Integer totalPage;
    //总记录数
    private Integer totalCount;

    public PageBean(Integer currentPage, Integer pageSize, Integer totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;

        if (currentPage == null || "".equals(currentPage)){
            currentPage = 1;
        }
        if (pageSize == null || "".equals(pageSize)){
            pageSize = 5;
        }
        //计算总页数
        totalPage = (totalCount - 1)/pageSize + 1;
        if (currentPage < 1){
            currentPage = 1;
        }
        if (currentPage > totalPage){
            currentPage = totalPage;
        }
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
