package org.example.p04bean;

public class Brand {
    private long bid;
    private String bname;

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                '}';
    }
}
