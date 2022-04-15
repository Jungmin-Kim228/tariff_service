package com.nhnacademy.project.repository;

import java.util.List;

public interface DataPaser {
    List<WaterBill> parse(String path);
}
