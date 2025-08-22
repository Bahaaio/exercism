class PrimeCalculator {
    boolean isPrime(int n) {
        for (int i = 2; i <= n / i; i++)
            if (n % i == 0)
                return false;
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
