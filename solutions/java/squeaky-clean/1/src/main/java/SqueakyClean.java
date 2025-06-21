import java.util.regex.Pattern;

class SqueakyClean {
    static String clean(String identifier) {
        // - followed by a non-special character
        var dashesPattern = Pattern.compile("-(\\w)");
        var matcher = dashesPattern.matcher(identifier);

        return
                // kebab-case to camelCase
                matcher.replaceAll(matchResult -> matchResult.group(1).toUpperCase())

                        // replace all whitespace with _
                        .replaceAll("\\s", "_")

                        // remove all special characters
                        .replaceAll("\\W", "")

                        // leetspeak mapping
                        .replace('4', 'a')
                        .replace('3', 'e')
                        .replace('0', 'o')
                        .replace('1', 'l')
                        .replace('7', 't');
    }
}
