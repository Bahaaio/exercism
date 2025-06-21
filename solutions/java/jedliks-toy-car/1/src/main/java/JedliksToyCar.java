public class JedliksToyCar {
    private int distance = 0;
    private int batteryPercentage = 100;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distance + " meters";
    }

    public String batteryDisplay() {
        if (batteryPercentage == 0) {
            return "Battery empty";
        }

        return "Battery at " + batteryPercentage + "%";
    }

    public void drive() {
        if (batteryPercentage == 0) {
            return;
        }
       
        distance += 20;
        --batteryPercentage;
    }
}
