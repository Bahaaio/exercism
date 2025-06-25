import java.util.Arrays;

class ResistorColor {
    int colorCode(String color) {
        return Color.valueOf(color).ordinal();
    }

    String[] colors() {
        return Arrays.stream(Color.values()).map(Color::name).toArray(String[]::new);
    }
}

enum Color {
    black, brown, red, orange, yellow, green, blue, violet, grey, white
}