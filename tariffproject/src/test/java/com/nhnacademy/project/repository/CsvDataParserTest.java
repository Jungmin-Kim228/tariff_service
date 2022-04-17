package com.nhnacademy.project.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
class CsvDataParserTest {
    @Autowired
    CsvDataParser csvDataParser;
    String path;

    @BeforeEach
    void setUp() {
        path = "data/Tariff_20220331.csv";
    }

    @DisplayName("parse와 trimContents가 정상적으로 동작했다면 result size는 303, 스페이스는 없어야함")
    @Test
    void parse_and_trimContents() {
        List<WaterBill> result = csvDataParser.parse(path);
        boolean checkSpace = false;

        for (WaterBill waterBill : result) {
            if (waterBill.getCity().contains(" ")) {
                checkSpace = true;
                break;
            }
        }

        assertThat(result).hasSize(303);
        assertThat(checkSpace).isFalse();
    }
}