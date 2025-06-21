import java.util.*;

class DnDCharacter {
    private final int STRENGTH = getRandomScore();
    private final int DEXTERITY = getRandomScore();
    private final int CONSTITUTION = getRandomScore();
    private final int INTELLIGENCE = getRandomScore();
    private final int WISDOM = getRandomScore();
    private final int CHARISMA = getRandomScore();

    int ability(List<Integer> scores) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.addAll(scores);

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += priorityQueue.poll();
        }

        return sum;
    }

    List<Integer> rollDice() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>(4);

        for (int i = 0; i < 4; i++) {
            numbers.add(random.nextInt(1, 7));
        }

        return numbers;
    }

    int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

    int getStrength() {
        return STRENGTH;
    }

    int getDexterity() {
        return DEXTERITY;
    }

    int getConstitution() {
        return CONSTITUTION;
    }

    int getIntelligence() {
        return INTELLIGENCE;
    }

    int getWisdom() {
        return WISDOM;
    }

    int getCharisma() {
        return CHARISMA;
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }

    private int getRandomScore() {
        return ability(rollDice());
    }
}
