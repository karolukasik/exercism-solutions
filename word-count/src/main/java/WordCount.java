import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class WordCount {
    public WordCount() {
    }

    public Map<String, Long> phrase(String phrase) {
        phrase = phrase.replaceAll("\n", " ");
        phrase = phrase.replaceAll("\t", " ");

        Map<String, Long> wordCount = Arrays.stream(phrase.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return wordCount;
    }

    public static void main(String[] args) {
        String phrase = "Ala ma\tkota\nkota";
        WordCount counter = new WordCount();
        System.out.println(counter.phrase(phrase));
    }
}
