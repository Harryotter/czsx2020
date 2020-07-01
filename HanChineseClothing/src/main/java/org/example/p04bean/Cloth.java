package org.example.p04bean;

public class Cloth {
    private long hid;
    private String hname;
    private String hIntroduce;
    private double hprice;

    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String gethIntroduce() {
        return hIntroduce;
    }

    public void sethIntroduce(String hIntroduce) {
        this.hIntroduce = hIntroduce;
    }

    public double getHprice() {
        return hprice;
    }

    public void setHprice(double hprice) {
        this.hprice = hprice;
    }

    @Override
    public String toString() {
        return "ClothDao{" +
                "hid=" + hid + ", hname='" + hname + '\'' + ", hIntroduce='" + hIntroduce + '\'' + ", hprice=" + hprice + '}';
    }
}
