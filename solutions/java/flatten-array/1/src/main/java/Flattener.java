import java.util.ArrayList;
import java.util.List;

class Flattener {
    List<Object> flatten(List<?> list) {
        var flattened = new ArrayList<>();

        list.forEach(item -> {
            if (item instanceof List<?>) {
                flattened.addAll(flatten((List<?>) item));
            } else if (item != null) {
                flattened.add(item);
            }
        });

        return flattened;
    }
}