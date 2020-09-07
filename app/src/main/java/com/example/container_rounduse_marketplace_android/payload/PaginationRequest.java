package com.example.container_rounduse_marketplace_android.payload;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class PaginationRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private int page;

    private int limit;

    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaginationRequest{" +
                "page=" + page +
                ", limit=" + limit +
                ", status='" + status + '\'' +
                '}';
    }
}
