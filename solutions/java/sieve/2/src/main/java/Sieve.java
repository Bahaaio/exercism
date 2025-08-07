import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sieve {
    private final List<Integer> sieve;

    Sieve(int maxPrime) {
        sieve = new ArrayList<>();
        initList(maxPrime);
    }

    private void initList(int maxPrime) {
        if (maxPrime < 2) {
            return;
        }

        boolean[] prime = new boolean[maxPrime + 1];
        Arrays.fill(prime, true);
        // prime[0] = prime[1] = false; // not needed

        for (int i = 2; i <= maxPrime; i++) {
            if (prime[i]) {
                sieve.add(i);
                for (int j = i * i; j <= maxPrime; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    List<Integer> getPrimes() {
        return sieve;
    }
}
