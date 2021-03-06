package com.nhnacademy.project.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

// csv 파일 파싱(필요없는 정보 제거, 공백 제거)
@Component
public class CsvDataParser implements DataPaser {
    private static final int FIRST_LINE_IGNORE = 8;
    @Override
    public List<WaterBill> parse(String path) {
        List<WaterBill> parseResult = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource(path).getInputStream()))) {
            while ((line = br.readLine()) != null) {
                String[] field = line.split(",");
                if (field.length == FIRST_LINE_IGNORE)
                    continue;
                trimContents(field);
                WaterBill waterBill = new WaterBill(Integer.parseInt(field[0]),field[1],field[2],Integer.parseInt(field[6]));
                parseResult.add(waterBill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseResult;
    }

    private void trimContents(String[] line) {
        for (int i = 0; i < line.length; i++)
            line[i] = line[i].trim();
    }
}
