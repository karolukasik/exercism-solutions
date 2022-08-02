import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class WordCount {
    public WordCount() {
    }

    public Map<String, Integer> phrase(String phrase) {
        phrase = " " + phrase + " ";
        phrase = phrase.toLowerCase().replaceAll("\n\t,", " ").replaceAll(",", " ")
                .replaceAll(" '", " ").replaceAll("' ", " ").replaceAll("[^a-z0-9 ']", "")
                .replaceAll(" +", " ").trim();

        Map<String, Integer> wordCount = Arrays.stream(phrase.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(word -> 1)));

        return wordCount;
    }

}
