import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return Set.copyOf(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return myCollection.stream().anyMatch(card -> !theirCollection.contains(card)) &&
                theirCollection.stream().anyMatch(card -> !myCollection.contains(card));
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        if (collections.isEmpty()) return Set.of();

        Set<String> common = new HashSet<>(collections.getFirst());

        for (int i = 1; i < collections.size(); i++)
            common.retainAll(collections.get(i)); // set intersection

        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return collections.stream().flatMap(Set::stream).collect(Collectors.toSet());
    }
}
