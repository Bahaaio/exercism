import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class NucleotideCounter {
    private final Map<Character, Integer> counts;

    NucleotideCounter(String sequence) {
        counts = new HashMap<>() {{
            Stream.of('A', 'G', 'C', 'T').forEach(c -> put(c, 0));
        }};

        for (char c : sequence.toCharArray()) {
            if (!counts.containsKey(c)) throw new IllegalArgumentException();
            counts.put(c, counts.get(c) + 1);
        }
    }

    Map<Character, Integer> nucleotideCounts() {
        return counts;
    }
}