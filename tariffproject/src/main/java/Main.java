import repository.BasicTariffRepository;
import repository.TariffRepository;
import repository.WaterBill;
import service.BasicResultReport;
import service.BasicTariffService;
import service.ResultReport;
import service.TariffService;

public class Main {
    public static void main(String[] args) {
        TariffService tariffService = new BasicTariffService();
        TariffRepository tariffRepository = new BasicTariffRepository();
        ResultReport resultReport = new BasicResultReport();

        tariffRepository.load();
        //System.out.println(tariffRepository.findAll());
        for (WaterBill waterBill : tariffRepository.findAll()) {
            System.out.println(waterBill.toString());
        }
        
    }
}
