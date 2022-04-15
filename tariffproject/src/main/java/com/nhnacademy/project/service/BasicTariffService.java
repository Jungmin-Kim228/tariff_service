package com.nhnacademy.project.service;

import com.nhnacademy.project.repository.BasicTariffRepository;
import org.springframework.stereotype.Service;
import com.nhnacademy.project.repository.TariffRepository;
import com.nhnacademy.project.repository.WaterBill;

@Service
public class BasicTariffService implements TariffService {
    private final TariffRepository tariffRepository;

    public BasicTariffService(BasicTariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public void calculateBillTotal(int bill) {
        for (WaterBill waterBill : tariffRepository.findAll()) {
            waterBill.setBillTotal(waterBill.getUnitPrice() * bill);
        }
    }
}
