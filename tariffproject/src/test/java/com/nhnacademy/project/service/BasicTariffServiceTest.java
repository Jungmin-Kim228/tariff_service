package com.nhnacademy.project.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.project.config.MainConfig;
import com.nhnacademy.project.repository.BasicTariffRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ContextConfiguration(classes = MainConfig.class)
@ExtendWith(SpringExtension.class)
class BasicTariffServiceTest {
    @Autowired
    BasicTariffService basicTariffService;
    @Autowired
    BasicTariffRepository basicTariffRepository;

    @BeforeEach
    void setUp() {
        basicTariffRepository.load();
    }

    @DisplayName("사용량 1000이면 첫 WaterBill의 요금은 690_000원")
    @Test
    void calculateBillTotal() {
        int bill = 1000;
        basicTariffService.calculateBillTotal(bill);

        assertThat(basicTariffRepository.findAll().get(0).getBillTotal()).isEqualTo(690_000);
    }
}