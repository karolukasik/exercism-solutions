import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1,
            ProductionRemoteControlCar prc2) {
        List<ProductionRemoteControlCar> rankedCars = new ArrayList<>();
        rankedCars.add(prc1);
        rankedCars.add(prc2);
        Collections.sort(rankedCars);
        return rankedCars;
    }

    public static void main(String[] args) {
        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(3);
        prc2.setNumberOfVictories(5);
        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(prc1, prc2);
        for (ProductionRemoteControlCar car : rankings) {
            System.out.println(car);
        }
    }
}
