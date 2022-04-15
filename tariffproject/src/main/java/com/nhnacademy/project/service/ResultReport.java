package com.nhnacademy.project.service;

import com.nhnacademy.project.repository.TariffRepository;

public interface ResultReport {
    // 결과 리포트(데이터)
    void reportTop5(TariffRepository basicTariffRepository);
}
