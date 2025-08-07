import java.util.Map;
import java.util.Stack;

class BracketChecker {
    private final String expression;
    private static final Map<Character, Character> CLOSING_TO_OPENING_BRACKET = Map.of(
            ']', '[',
            ')', '(',
            '}', '{'
    );

    BracketChecker(String expression) {
        this.expression = expression;
    }

    private boolean isOpeningBracket(char c) {
        return CLOSING_TO_OPENING_BRACKET.containsValue(c);
    }

    private boolean isClosingBracket(char c) {
        return CLOSING_TO_OPENING_BRACKET.containsKey(c);
    }

    private boolean areMatchingBrackets(char closing, char opening) {
        return CLOSING_TO_OPENING_BRACKET.get(closing) == opening;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char cur = expression.charAt(i);

            if (isOpeningBracket(cur)) {
                stack.push(cur);
            } else if (isClosingBracket(cur)) {
                if (stack.empty() || !areMatchingBrackets(cur, stack.peek())) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.empty();
    }
}