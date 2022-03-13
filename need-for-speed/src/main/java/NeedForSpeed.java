class NeedForSpeed {
    private int carSpeedMetersPerHour;
    private int batteryCapacityPercentage;
    private int batteryDrainPercentage;
    private int distanceDriven;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.carSpeedMetersPerHour = speed;
        this.batteryCapacityPercentage = 100;
        this.batteryDrainPercentage = batteryDrain;
        this.distanceDriven = 0;
    }

    public boolean batteryDrained() {
        return this.batteryCapacityPercentage - this.batteryDrainPercentage < 0;
    }

    public int getBatteryCapacityPercentage() {
        return batteryCapacityPercentage;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if (!batteryDrained()) {
            this.distanceDriven += this.carSpeedMetersPerHour;
            this.batteryCapacityPercentage -= this.batteryDrainPercentage;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    public static void main(String[] args) {
        int speed = 5;
        int batteryDrain = 6;
        var car = new NeedForSpeed(speed, batteryDrain);

        int distance = 100;
        var race = new RaceTrack(distance);

        ;
        System.out.println(race.carCanFinish(car));
    }
}

class RaceTrack {
    private int distanceInMeters;

    public RaceTrack(int distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    public boolean carCanFinish(NeedForSpeed car) {
        while (!car.batteryDrained()) {
            car.drive();
        }
        return car.distanceDriven() >= this.distanceInMeters;
    }
}
