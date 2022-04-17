package com.nhnacademy.project.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.project.config.MainConfig;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = MainConfig.class)
@ExtendWith(SpringExtension.class)
class BasicTariffRepositoryTest {
    @Autowired
    BasicTariffRepository basicTariffRepository;

    @BeforeEach
    void setUp() {
        basicTariffRepository.load();
    }

    // csv 파일 내 350번 중 몇몇 번호들이 빠져있음. size는 303이 맞음
    @DisplayName("Tariff_20220331.csv가 빈 파일이 아니며, 303가지의 요금표 존재")
    @Test
    void load_and_findAll() {
        assertThat(basicTariffRepository.findAll()).isNotEmpty();
        assertThat(basicTariffRepository.findAll()).hasSize(303);
    }

    @DisplayName("사용량 1000이면 첫 WaterBill의 요금은 690_000원")
    @Test
    void setBillTotal() {
        int bill = 1000;
        basicTariffRepository.setBillTotal(bill);

        assertThat(basicTariffRepository.findAll().get(0).getBillTotal()).isEqualTo(690_000);
    }

    @DisplayName("저렴한 가격 Top5 추출 시 size 5, 1st:2200원, 5th:3450원")
    @Test
    void findTop5() {
        int bill = 10;
        int compareBillTotal = 0;
        boolean sorted = true;
        basicTariffRepository.setBillTotal(bill);
        List<WaterBill> top5List = basicTariffRepository.findTop5();

        for (WaterBill waterBill : top5List) {
            if (waterBill.getBillTotal() < compareBillTotal) {
                sorted = false;
                break;
            }
            compareBillTotal = waterBill.getBillTotal();
        }

        assertThat(top5List).hasSize(5);
        assertThat(sorted).isTrue();
        assertThat(top5List.get(0).getBillTotal()).isEqualTo(2200);
        assertThat(top5List.get(4).getBillTotal()).isEqualTo(3450);
    }
}