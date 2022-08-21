
import java.util.Arrays;
import java.util.List;

public class PigLatinTranslator {

    private List<Character> vovels = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private List<String> vovelSounds = Arrays.asList("xr", "yt");
    private List<String> consonantClusters = Arrays.asList("ch", "rh", "qu", "th", "sch", "thr");

    public String translate(String phrase) {
        String[] wordsToTranslate = phrase.split(" ");
        StringBuilder phraseTranslated = new StringBuilder();
        for (String word : wordsToTranslate) {
            phraseTranslated.append(selectRuleAndTranslate(word)).append(" ");
        }

        return phraseTranslated.toString().trim();
    }

    public String selectRuleAndTranslate(String word) {
        char firstChar = word.charAt(0);
        // check if word starts from vovel or not
        if (vovels.contains(firstChar)) {
            return applyRuleOne(word);
        } else if (word.length() == 2) /* rules for words starting from consonant and containing only two chars */ {
            if (word.charAt(1) == 'y') {
                String charsBeforeY = String.valueOf(word.charAt(0));
                return applyRuleFour(word, charsBeforeY);
            }
            return applyRuleTwo(word, firstChar);
        } else /* rules for words longer than two chars, starting from consonant */ {
            String twoFirstChars = word.substring(0, 2);
            String threeFirstChars = word.substring(0, 3);
            if (vovelSounds.contains(twoFirstChars)) /* rule for two chars making a vovel sound */ {
                return applyRuleOne(word);
            } else if (consonantClusters.contains(threeFirstChars)) /*
                                                                     * rule for words starting from three-chars
                                                                     * consonant clusters
                                                                     */ {
                return applyRuleTwo(word, threeFirstChars);
            } else if (consonantClusters.contains(twoFirstChars)) /*
                                                                   * rules for words starting from two-chars consonant
                                                                   * clusters...
                                                                   */ {
                if (word.charAt(2) == 'y') /* ... having 'y' right after them... */ {
                    return applyRuleFour(word, twoFirstChars);
                } /* ...or not having 'y' right after them */
                return applyRuleTwo(word, twoFirstChars);
            }
            /* rule for consonant sound followed by 'qu' */
            String secondAndThirdChars = word.substring(1, 3);
            if (secondAndThirdChars.equals("qu")) {
                return applyRuleThree(word);
            }
            /* simple rule two for words starting from consonant */
            return applyRuleTwo(word, firstChar);
        }

    }

    private String applyRuleFour(String word, String charsBeforeY) {
        StringBuilder translatedWord = new StringBuilder(word.length() + 2);
        int indexOfY = word.indexOf("y");
        return translatedWord
                .append(word.substring(indexOfY, word.length()))
                .append(charsBeforeY)
                .append("ay")
                .toString();
    }

    private String applyRuleThree(String word) {
        StringBuilder translatedWord = new StringBuilder(word.length() + 2);
        return translatedWord
                .append(word.substring(3, 6))
                .append(word.substring(0, 3))
                .append("ay")
                .toString();
    }

    private String applyRuleTwo(String word, char firstChar) {
        return word.substring(1, word.length()) + firstChar + "ay";
    }

    private String applyRuleTwo(String word, String consonantCluster) {
        if (consonantCluster.length() == 3) {
            return word.substring(3, word.length()) + consonantCluster + "ay";
        }
        return word.substring(2, word.length()) + consonantCluster + "ay";
    }

    private String applyRuleOne(String word) {
        return word + "ay";
    }

    public static void main(String[] args) {
        String phrase = "my";
        PigLatinTranslator translator = new PigLatinTranslator();
        System.out.println(translator.translate(phrase));

    }

}
