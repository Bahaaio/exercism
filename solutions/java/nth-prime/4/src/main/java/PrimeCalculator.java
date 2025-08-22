class PrimeCalculator {
    boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i <= n / i; i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;

        return true;
    }

    int nth(int nth) {
        if (nth <= 0) throw new IllegalArgumentException();

        int current = 1;
        for (int counter = 0; counter < nth; ) {
            ++current;
            if (isPrime(current)) ++counter;
        }

        return current;
    }
}
