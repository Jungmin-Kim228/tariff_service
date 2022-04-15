import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.nhnacademy.project.repository.BasicTariffRepository;
import com.nhnacademy.project.repository.TariffRepository;
import com.nhnacademy.project.service.BasicTariffService;
import com.nhnacademy.project.service.TariffService;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                 new AnnotationConfigApplicationContext("com.nhnacademy")) {
            TariffRepository tariffRepository = context
                .getBean("basicTariffRepository", BasicTariffRepository.class);
            TariffService basicTariffService = context.getBean("basicTariffService", BasicTariffService.class);
            tariffRepository.load();
            basicTariffService.calculateBillTotal(1000);
            System.out.println(tariffRepository.findAll().toString());
        }
    }
}
