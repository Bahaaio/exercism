public class CarsAssemble {

    double calculateSuccessRate(int speed) {
        if (speed < 5) {
            return 1.0;
        } else if (speed < 9) {
            return 0.9;
        } else if (speed < 10) {
            return 0.8;
        } else {
            return 0.77;
        }
    }

    public double productionRatePerHour(int speed) {
        int carsPerHour = speed * 221;

        return carsPerHour * calculateSuccessRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int)productionRatePerHour(speed) / 60;
    }
}
