import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class NucleotideCounter {
    private final Map<Character, Integer> counts;
    private final static Set<Character> ALLOWED = Set.of('A', 'C', 'G', 'T');

    NucleotideCounter(String sequence) {
        counts = new HashMap<>();
        for (char c : ALLOWED) {
            counts.put(c, 0);
        }

        for (char c : sequence.toCharArray()) {
            if (!ALLOWED.contains(c)) {
                throw new IllegalArgumentException();
            }

            counts.put(c, counts.get(c) + 1);
        }
    }

    Map<Character, Integer> nucleotideCounts() {
        return counts;
    }
}