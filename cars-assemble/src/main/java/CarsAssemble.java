import java.math.BigDecimal;
import java.math.RoundingMode;
//import java.util.Locale;

public class CarsAssemble {
    private final int basicCarsProduceRate = 221;

    public CarsAssemble() {

    }

    public double productionRatePerHour(int speed) {
        if (successRate(speed) == -1) {
            return -1;
        }

        double productionRate = successRate(speed) * basicCarsProduceRate * speed;
        BigDecimal b = new BigDecimal(productionRate);
        System.out.println(b);
        b = b.setScale(2, RoundingMode.HALF_UP);
        System.out.println(b);
        // Locale l = Locale.US;
        // String productionRateAsString = String.format(l, "%.1f", productionRate);
        // double productionRateCorrectPrecision =
        // Double.valueOf(productionRateAsString);
        return b.doubleValue();
    }

    public double successRate(int speed) {

        if (speed == 0) {
            return 0;
        } else if (speed >= 1 && speed <= 4) {
            return 1;
        } else if (speed >= 5 && speed <= 8) {
            return 0.9;
        } else if (speed == 9) {
            return 0.8;
        } else if (speed == 10) {
            return 0.77;
        } else {
            return -1;
        }

    }

    public int workingItemsPerMinute(int speed) {
        int workingCarsPerMinute = (int) productionRatePerHour(speed) / 60;
        return workingCarsPerMinute;
    }
}
