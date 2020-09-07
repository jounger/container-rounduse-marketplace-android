package com.example.container_rounduse_marketplace_android.payload;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;



public class PaginationResponse<E> implements Serializable {
    private static final long serialVersionUID = 1L;


    private int page;
    private int limit;
    private long totalElements;
    private int totalPages;
    private List<E> data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PaginationResponse{" +
                "page=" + page +
                ", limit=" + limit +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }
}
