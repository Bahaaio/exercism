import java.util.*;

class DnDCharacter {
    private final Random random = new Random();
    private final int strength = getRandomScore();
    private final int dexterity = getRandomScore();
    private final int constitution = getRandomScore();
    private final int intelligence = getRandomScore();
    private final int wisdom = getRandomScore();
    private final int charisma = getRandomScore();

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
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            numbers.add(random.nextInt(1, 7));
        }

        return numbers;
    }

    int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }

    private int getRandomScore() {
        return ability(rollDice());
    }
}
