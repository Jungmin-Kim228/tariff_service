package com.nhnacademy.project.repository;

import java.util.List;

// csv 파일 메모리 로드, 조회
public interface TariffRepository {
    void load();

    List<WaterBill> findAll();

    void setBillTotal(int bill);

    List<WaterBill> findTop5();
}
