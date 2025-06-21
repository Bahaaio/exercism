import java.util.*;

class DnDCharacter {
    private final Random random = new Random();
    private final int strength = getRandomScore();
    private final int dexterity = getRandomScore();
    private final int constitution = getRandomScore();
    private final int intelligence = getRandomScore();
    private final int wisdom = getRandomScore();
    private final int charisma = getRandomScore();
    private final int hitPoints = 10 + modifier(constitution);

    private int getRandomScore() {
        return ability(rollDice());
    }

    int ability(List<Integer> scores) {
        return scores.stream().sorted().skip(1).reduce(0, Integer::sum);
    }

    List<Integer> rollDice() {
        return random.ints(4, 1, 7).boxed().toList();
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
        return hitPoints;
    }
}
