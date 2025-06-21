class NeedForSpeed {
    public final int speed, batteryDrain;
    private int distanceCovered = 0;
    private int batteryPercentage = 100;

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
        return Math.ceilDiv(distance * car.batteryDrain, car.speed) <= 100;
    }
}
