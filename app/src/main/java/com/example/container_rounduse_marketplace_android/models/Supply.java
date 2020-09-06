package com.example.container_rounduse_marketplace_android.models;

public class Supply {
    private Long id;

    private String code;

    private ShippingLine shippingLine;

    private ContainerType containerType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ShippingLine getShippingLine() {
        return shippingLine;
    }

    public void setShippingLine(ShippingLine shippingLine) {
        this.shippingLine = shippingLine;
    }

    public ContainerType getContainerType() {
        return containerType;
    }

    public void setContainerType(ContainerType containerType) {
        this.containerType = containerType;
    }
}
