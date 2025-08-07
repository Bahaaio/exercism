import java.util.Arrays;

class ResistorColorDuo {
    int value(String[] colors) {
        return Color.valueOf(colors[0]).ordinal() * 10 + Color.valueOf(colors[1]).ordinal();
    }
}
