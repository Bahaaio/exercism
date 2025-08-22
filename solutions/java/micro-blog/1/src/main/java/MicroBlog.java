class MicroBlog {
    public String truncate(String input) {
        if (input.codePointCount(0, input.length()) > 5) {
            var codePoints = input.codePoints().limit(5).toArray();
            return new String(codePoints, 0, 5);
        }
        return input;
    }
}
