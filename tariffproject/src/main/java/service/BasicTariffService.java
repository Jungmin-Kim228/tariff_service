package service;

import repository.BasicTariffRepository;
import repository.TariffRepository;
import repository.WaterBill;

public class BasicTariffService implements TariffService {
    private final TariffRepository tariffRepository = new BasicTariffRepository();

    public void calculateBillTotal(int bill) {
        for (WaterBill waterBill : tariffRepository.findAll()) {
            waterBill.setBillTotal(waterBill.getUnitPrice() * bill);
        }
    }
}
