class IsbnVerifier {
    boolean isValid(String isbn) {
        int num = 0, count = 0;

        for (int i = 0; i < isbn.length(); i++) {
            char cur = isbn.charAt(i);

            if (!(cur == '-' || cur == 'X' || (cur >= '0' && cur <= '9'))) {
                return false;
            }

            if (cur != '-') {
                if (i == isbn.length() - 1) {
                    num += (cur == 'X' ? 10 : cur - '0') * (10 - count);
                } else {
                    num += (cur - '0') * (10 - count);
                }

                ++count;
            }
        }

        return count == 10 && num % 11 == 0;
    }
}
