package repository;

import java.util.List;

// csv 파일 메모리 로드, 조회
public class BasicTariffRepository implements TariffRepository {
    private List<WaterBill> waterBillList;
    private DataPaser dataPaser = new CsvDataParser();

    public void load() {
        String path = "data/Tariff_20220331.csv";
        this.waterBillList = dataPaser.parse(path);
    }

    public List<WaterBill> findAll() {
        return this.waterBillList;
    }

}
