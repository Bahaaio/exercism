import java.util.ArrayList;
import java.util.Set;

class PigLatinTranslator {
    private final static Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    private final static String SUFFIX = "ay";

    public String translate(String phrase) {
        var words = new ArrayList<String>();

        for (String word : phrase.split(" ")) {
            if (VOWELS.contains(word.charAt(0)) || word.startsWith("xr") || word.startsWith("yt")) {
                words.add(word + SUFFIX);
                continue;
            }

            for (int i = 1; i < word.length(); i++) {
                if (VOWELS.contains(word.charAt(i)) || word.charAt(i) == 'y') {
                    if (word.charAt(i) == 'u' && word.charAt(i - 1) == 'q') i++;

                    words.add(word.substring(i) + word.substring(0, i) + SUFFIX);
                    break;
                }
            }
        }

        return String.join(" ", words);
    }
}