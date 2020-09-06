package com.example.container_rounduse_marketplace_android.payload;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class PaginationRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer page;

    @NotNull
    private Integer limit;

    private String status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @NotNull
    public Integer getPage() {
        return page;
    }

    public void setPage(@NotNull Integer page) {
        this.page = page;
    }

    @NotNull
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(@NotNull Integer limit) {
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
