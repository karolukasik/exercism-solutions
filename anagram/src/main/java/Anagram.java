
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    private String word;
    private List<Integer> charsInWordSorted;

    public Anagram(String word) {
        this.word = word.toLowerCase();
        this.charsInWordSorted = convertStringToListOfIntegers(this.word);
    }

    public List<String> match(List<String> candidates) {
        List<String> matchingWords = new ArrayList<>();

        for (String candidate : candidates) {
            if (candidate.toLowerCase().equals(this.word)) {
                continue;
            }
            List<Integer> charsInCandidateSorted = convertStringToListOfIntegers(candidate);
            if (charsInCandidateSorted.equals(this.charsInWordSorted)) {
                matchingWords.add(candidate);
            }
        }
        return matchingWords;
    }

    private List<Integer> convertStringToListOfIntegers(String word) {
        return word.toLowerCase().chars().sorted().boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}