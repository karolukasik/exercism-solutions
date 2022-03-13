public class ElonsToyCar {
    private int distanceDriven;
    private int batteryPercentage;

    public ElonsToyCar() {
        this.distanceDriven = 0;
        this.batteryPercentage = 100;
    }

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + this.distanceDriven + " meters";
    }

    public String batteryDisplay() {
        if (this.batteryPercentage == 0) {
            return "Battery empty";
        }
        return "Battery at " + this.batteryPercentage + "%";
    }

    public void drive() {
        if (this.batteryPercentage > 0) {
            this.distanceDriven += 20;
            this.batteryPercentage -= 1;
        }
    }

    public static void main(String[] args) {
        ElonsToyCar car = buy();
        car.drive();
        System.out.println(car.batteryDisplay());
        System.out.println(car.distanceDisplay());
        for (int i = 0; i < 105; i++) {
            car.drive();
        }
        System.out.println(car.batteryDisplay());
        System.out.println(car.distanceDisplay());

    }
}
