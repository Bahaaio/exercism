
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        ++birdsPerDay[birdsPerDay.length - 1];
    }

    public boolean hasDayWithoutBirds() {
        for (int count : birdsPerDay) {
            if (count == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int sum = 0;
        for (int day = 0; day < numberOfDays && day < birdsPerDay.length; ++day) {
            sum += birdsPerDay[day];
        }
        return sum;
    }

    public int getBusyDays() {
        int busyCount = 0;

        for (int count : birdsPerDay) {
            if (count >= 5) {
                ++busyCount;
            }
        }
        return busyCount;
    }
}
