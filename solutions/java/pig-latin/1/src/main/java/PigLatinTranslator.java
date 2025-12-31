import java.util.ArrayList;
import java.util.Set;

class PigLatinTranslator {
    private final static Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    private final static String SUFFIX = "ay";

    public String translate(String phrase) {
        var words = new ArrayList<String>();

        for (String word : phrase.split(" ")) {
            words.add(translateWord(word));
        }

        return String.join(" ", words);
    }

    public String translateWord(String word) {
        if (word.startsWith("xr") || word.startsWith("yt")) {
            return word + SUFFIX;
        }

        for (int i = 0; i < word.length(); i++) {
            if (VOWELS.contains(word.charAt(i)) || (i != 0 && word.charAt(i) == 'y')) {
                return word.substring(i) + word.substring(0, i) + SUFFIX;
            }

            if (word.charAt(i) == 'q' && i + 1 < word.length() && word.charAt(i + 1) == 'u') {
                return word.substring(i + 2) + word.substring(0, i + 2) + SUFFIX;
            }
        }

        return word;
    }
}