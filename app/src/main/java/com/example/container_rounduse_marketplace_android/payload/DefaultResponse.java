package com.example.container_rounduse_marketplace_android.payload;

import java.io.Serializable;

public class DefaultResponse<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private E data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DefaultResponse{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
