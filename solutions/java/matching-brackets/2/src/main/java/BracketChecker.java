import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Predicate;

class BracketChecker {
    private final String expression;

    BracketChecker(String expression) {
        this.expression = expression;
    }

    private static final Set<Character> OPENING_BRACKETS = Set.of('[', '(', '{');
    private static final Set<Character> CLOSING_BRACKETS = Set.of(']', ')', '}');
    private static final Map<Character, Character> CLOSING_TO_OPENING_BRACKET = Map.of(
            ']', '[',
            ')', '(',
            '}', '{'
    );


    boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char cur = expression.charAt(i);

            if (OPENING_BRACKETS.contains(cur)) {
                brackets.push(cur);
            } else if (CLOSING_BRACKETS.contains(cur)) {
                if (brackets.empty() || CLOSING_TO_OPENING_BRACKET.get(cur) != brackets.peek()) {
                    return false;
                }

                brackets.pop();
            }
        }

        return brackets.empty();
    }
}