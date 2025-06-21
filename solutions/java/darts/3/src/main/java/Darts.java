import java.util.function.DoublePredicate;

class Darts {
    private final static double OUTER_RING  = 10;
    private final static double MIDDLE_RING =  5;
    private final static double INNER_RING  =  1;

    int score(double xOfDart, double yOfDart) {
        double distance = Math.hypot(xOfDart, yOfDart);
        DoublePredicate within = radius -> distance <= radius;

        if (within.test(INNER_RING))
            return 10;
        else if (within.test(MIDDLE_RING))
            return 5;
        else if (within.test(OUTER_RING))
            return 1;
        else
            return 0;
    }
}
