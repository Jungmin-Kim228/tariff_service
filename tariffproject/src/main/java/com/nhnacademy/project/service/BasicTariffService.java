package com.nhnacademy.project.service;

import com.nhnacademy.project.repository.BasicTariffRepository;
import org.springframework.stereotype.Service;
import com.nhnacademy.project.repository.TariffRepository;

@Service
public class BasicTariffService implements TariffService {
    private final TariffRepository tariffRepository;

    public BasicTariffService(BasicTariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public void calculateBillTotal(int bill) {
        tariffRepository.setBillTotal(bill);
    }
}
