import java.util.Map;
import java.util.Stack;
import java.util.function.Predicate;

class BracketChecker {
    private final String expression;

    BracketChecker(String expression) {
        this.expression = expression;
    }

    private static final Predicate<Character> IS_OPENING_BRACKET = c -> "[({".indexOf(c) != -1;
    private static final Predicate<Character> IS_CLOSING_BRACKET = c -> "])}".indexOf(c) != -1;
    private static final Map<Character, Character> OPENING_BRACKET = Map.of(
            ']', '[',
            ')', '(',
            '}', '{'
    );


    boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char cur = expression.charAt(i);

            if (IS_OPENING_BRACKET.test(cur)) {
                brackets.push(cur);
            } else if (IS_CLOSING_BRACKET.test(cur)) {
                if (brackets.empty() || OPENING_BRACKET.get(cur) != brackets.peek()) {
                    return false;
                }

                brackets.pop();
            }
        }

        return brackets.empty();
    }
}