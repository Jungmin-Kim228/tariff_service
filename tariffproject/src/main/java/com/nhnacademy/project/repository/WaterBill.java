package com.nhnacademy.project.repository;

public class WaterBill {
    private int seq;
    private String city;
    private String sector;
    private int unitPrice;
    private int billTotal;

    public WaterBill(int seq, String city, String sector, int unitPrice) {
        this.seq = seq;
        this.city = city;
        this.sector = sector;
        this.unitPrice = unitPrice;
    }

    public void setBillTotal(int billTotal) {
        this.billTotal = billTotal;
    }

    public int getUnitPrice() {
        return this.unitPrice;
    }

    public int getBillTotal() {
        return this.billTotal;
    }

    @Override
    public String toString() {
        return "WaterBill{" +
            "seq=" + seq +
            ", city='" + city + '\'' +
            ", sector='" + sector + '\'' +
            ", unitPrice=" + unitPrice +
            ", BillTotal=" + billTotal +
            '}';
    }

    // test code를 위해 작성
    public String getCity() {
        return this.city;
    }

    // test code를 위해 작성
    public String getSector() {
        return this.sector;
    }
}
