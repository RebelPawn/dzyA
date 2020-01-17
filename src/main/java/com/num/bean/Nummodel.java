package com.num.bean;

import java.math.BigDecimal;

public class Nummodel {
    private int id;
    private int numId;
    private BigDecimal data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public BigDecimal getData() {
        return data;
    }

    public void setData(BigDecimal data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Nummodel{" +
                "id=" + id +
                ", numId=" + numId +
                ", data=" + data +
                '}';
    }
}
