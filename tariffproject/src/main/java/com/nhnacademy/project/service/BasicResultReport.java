package com.nhnacademy.project.service;

import com.nhnacademy.project.repository.TariffRepository;
import com.nhnacademy.project.repository.WaterBill;
import org.springframework.stereotype.Service;

// 결과 화면 출력
@Service
public class BasicResultReport implements ResultReport {
    // 결과 리포트(데이터)
    @Override
    public void reportTop5(TariffRepository basicTariffRepository) {
        for (WaterBill waterBill : basicTariffRepository.findTop5()) {
            System.out.println(waterBill.toString());
        }
    }

}
