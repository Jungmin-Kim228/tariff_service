package com.nhnacademy.project.repository;

import java.util.List;
import org.springframework.stereotype.Component;

// csv 파일 메모리 로드, 조회
@Component
public class BasicTariffRepository implements TariffRepository {
    private final DataPaser dataPaser;
    private List<WaterBill> waterBillList;

    public BasicTariffRepository(DataPaser dataPaser) {
        this.dataPaser = dataPaser;
    }

    @Override
    public void load() {
        String path = "data/Tariff_20220331.csv";
        this.waterBillList = dataPaser.parse(path);
    }

    @Override
    public List<WaterBill> findAll() {
        return this.waterBillList;
    }

}
