package com.nhnacademy.project.main;

import com.nhnacademy.project.repository.BasicTariffRepository;
import com.nhnacademy.project.repository.TariffRepository;
import com.nhnacademy.project.service.BasicResultReport;
import com.nhnacademy.project.service.BasicTariffService;
import com.nhnacademy.project.service.ResultReport;
import com.nhnacademy.project.service.TariffService;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bill;

        try (AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.nhnacademy")) {

            TariffRepository basicTariffRepository =
                context.getBean("basicTariffRepository", BasicTariffRepository.class);
            TariffService basicTariffService =
                context.getBean("basicTariffService", BasicTariffService.class);
            ResultReport resultReport =
                context.getBean("basicResultReport", BasicResultReport.class);

            basicTariffRepository.load();

            while (true) {
                System.out.print("상수도 사용량 입력(0 입력 시 종료)\n> ");
                bill = scan.nextInt();
                if (checkQuit(bill))
                    return;
                basicTariffService.calculateBillTotal(bill);
                resultReport.reportTop5(basicTariffRepository);
            }
        }
    }

    static boolean checkQuit(int fee) {
        if (fee == 0) {
            System.out.println("프로그램 종료");
            return true;
        }
        return false;
    }
}
