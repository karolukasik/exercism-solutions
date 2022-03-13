
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        int[] lastWeek = { 0, 2, 5, 3, 7, 8, 4 };
        return lastWeek;
    }

    public int getToday() {
        if (this.birdsPerDay.length > 0) {
            return this.birdsPerDay[6];
        } else {
            return 0;
        }

    }

    public void incrementTodaysCount() {
        this.birdsPerDay[6] = this.getToday() + 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int day : birdsPerDay) {
            if (day == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        if (numberOfDays <= 7) {
            return countingForFirstDays(numberOfDays);
        } else {
            return countingForFirstDays(7);
        }
    }

    public int getBusyDays() {
        int busyDays = 0;
        for (int day : birdsPerDay) {
            if (day >= 5) {
                busyDays++;
            }
        }
        return busyDays;
    }

    public int countingForFirstDays(int numberOfDays) {
        int sum = 0;
        for (int i = 0; i < numberOfDays; i++) {
            sum += this.birdsPerDay[i];
        }
        return sum;
    }
}
