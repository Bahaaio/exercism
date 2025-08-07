class IsbnVerifier {
    boolean isValid(String isbn) {
        int sum = 0, count = 0;

        for (int i = 0; i < isbn.length(); i++) {
            char cur = isbn.charAt(i);

            if (cur == '-') {
                continue;
            }

            if (Character.isDigit(cur)) {
                sum += (cur - '0') * (10 - count);
                ++count;
            } else if (cur == 'X' && i == isbn.length() - 1) {
                sum += 10;
                ++count;
            } else {
                return false;
            }
        }

        return count == 10 && sum % 11 == 0;
    }
}
