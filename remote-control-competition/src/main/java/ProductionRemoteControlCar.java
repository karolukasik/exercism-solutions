class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int distanceDriven;
    private int numberofVictories;

    public void drive() {
        this.distanceDriven += 10;
    }

    public int getDistanceTravelled() {
        return this.distanceDriven;
    }

    public int getNumberOfVictories() {
        return this.numberofVictories;
    }

    public void setNumberOfVictories(int numberofVictories) {
        this.numberofVictories = numberofVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        // TODO Auto-generated method stub
        return this.numberofVictories - otherCar.numberofVictories;
    }

    @Override
    public String toString() {
        return "this car has " + this.numberofVictories + " victories";
    }
}
