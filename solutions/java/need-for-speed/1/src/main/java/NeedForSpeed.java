class NeedForSpeed {
    public final int speed;
    public final int batteryDrain;
    private int distanceCovered = 0;
    public int batteryPercentage = 100;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return batteryPercentage < batteryDrain;
    }

    public int distanceDriven() {
        return distanceCovered;
    }

    public void drive() {
        if (!batteryDrained()) {
            distanceCovered += speed;
            batteryPercentage -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private final int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        final int numberOfDrives = Math.ceilDiv(distance, car.speed);
        final int batteryNeeded = numberOfDrives * car.batteryDrain;
        return car.batteryPercentage >= batteryNeeded;
    }
}
