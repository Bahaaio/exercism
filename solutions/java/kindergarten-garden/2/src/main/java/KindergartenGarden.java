import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {
    private final String[] garden;

    KindergartenGarden(String garden) {
        this.garden = garden.split("\n");
    }

    List<Plant> getPlantsOfStudent(String student) {
        int index = (student.charAt(0) - 'A') << 1;

        List<Plant> plants = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            for (int j = index; j < index + 2; j++) {
                plants.add(Plant.getPlant(garden[i].charAt(j)));
            }
        }

        return plants;
    }
}
