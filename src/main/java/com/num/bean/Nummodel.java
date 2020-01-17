package com.num.bean;

public class Nummodel {
    private int id;
    private int numId;
    private double data;

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

    public double getData() {
        return data;
    }

    public void setData(double data) {
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
