package com.nhnacademy.project.repository;

import java.util.Comparator;

public class WaterBillComparator implements Comparator<WaterBill> {

    @Override
    public int compare(WaterBill o1, WaterBill o2) {
        int o1Bill = o1.getBillTotal();
        int o2Bill = o2.getBillTotal();

        if (o1Bill > o2Bill) return 1;
        if (o1Bill < o2Bill) return -1;
        return 0;
    }
}
