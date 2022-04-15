package repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.ClassPathResource;

// csv 파일 파싱(필요없는 정보 제거, 공백 제거)
public class CsvDataParser implements DataPaser {

    @Override
    public List<WaterBill> parse(String path) {
        List<WaterBill> parseResult = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource(path).getInputStream()))) {
            while ((line = br.readLine()) != null) {
                String[] field = line.trim().split(",");
                WaterBill waterBill = new WaterBill(Integer.parseInt(field[0]),field[1],field[2],Integer.parseInt(field[6]));
                parseResult.add(waterBill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseResult;
    }
}
