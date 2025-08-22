class PrimeCalculator {
    boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= n / i; i += 2)
            if (n % i == 0) return false;

        return true;
    }

    int nth(int nth) {
        if (nth <= 0) {
            throw new IllegalArgumentException();
        }

        int counter = 0, number = 2;

        while (true) {
            if (isPrime(number)) ++counter;
            if (counter == nth) return number;
            ++number;
        }
    }
}
