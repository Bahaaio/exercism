import java.util.Arrays;

class ResistorColorDuo {
    int value(String[] colors) {
        return Arrays.stream(colors)
                .limit(2)
                .mapToInt((color) -> Color.valueOf(color).ordinal())
                .reduce(0, (id, x) -> {
                    id *= 10;
                    return id + x;
                });

    }
}
