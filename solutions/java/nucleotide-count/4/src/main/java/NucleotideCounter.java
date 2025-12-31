import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {
    private final Map<Character, Integer> counts;

    NucleotideCounter(String sequence) {
        counts = new HashMap<>() {{
            put('A', 0);
            put('G', 0);
            put('C', 0);
            put('T', 0);
        }};

        for (char c : sequence.toCharArray()) {
            if (!counts.containsKey(c)) throw new IllegalArgumentException();
            counts.merge(c, 1, Integer::sum);
        }
    }

    Map<Character, Integer> nucleotideCounts() {
        return counts;
    }
}