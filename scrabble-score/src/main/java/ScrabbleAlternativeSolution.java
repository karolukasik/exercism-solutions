import java.util.HashMap;
import java.util.Map;

//link to the original version: https://exercism.org/tracks/java/exercises/scrabble-score/solutions/YukinStacy

class ScrabbleAlternativeSolution {
    private static final Map<Integer, Integer> letterScore = new HashMap<>(26);
    private String wordLowerCase;

    static {
        "aeioulnrst".chars().forEach(letter -> letterScore.put(letter, 1));
        "dg".chars().forEach(letter -> letterScore.put(letter, 2));
        "bcmp".chars().forEach(letter -> letterScore.put(letter, 3));
        "fhvwy".chars().forEach(letter -> letterScore.put(letter, 4));
        "k".chars().forEach(letter -> letterScore.put(letter, 5));
        "jx".chars().forEach(letter -> letterScore.put(letter, 8));
        "qz".chars().forEach(letter -> letterScore.put(letter, 10));
    }

    ScrabbleAlternativeSolution(String word) {
        this.wordLowerCase = word.toLowerCase();
    }

    int getScore() {
        return wordLowerCase.chars().reduce(0, (a, b) -> a + letterScore.get(b));
    }

}
