package com.num.bean;

public class PV {
    private int id;
    private int pv1;
    private int pv2;
    private int pv3;
    private int pv4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPv1() {
        return pv1;
    }

    public void setPv1(int pv1) {
        this.pv1 = pv1;
    }

    public int getPv2() {
        return pv2;
    }

    public void setPv2(int pv2) {
        this.pv2 = pv2;
    }

    public int getPv3() {
        return pv3;
    }

    public void setPv3(int pv3) {
        this.pv3 = pv3;
    }

    public int getPv4() {
        return pv4;
    }

    public void setPv4(int pv4) {
        this.pv4 = pv4;
    }

    @Override
    public String toString() {
        return "PV{" +
                "id=" + id +
                ", pv1=" + pv1 +
                ", pv2=" + pv2 +
                ", pv3=" + pv3 +
                ", pv4=" + pv4 +
                '}';
    }
}
