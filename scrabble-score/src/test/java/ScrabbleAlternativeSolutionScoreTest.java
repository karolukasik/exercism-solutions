import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScrabbleAlternativeSolutionScoreTest {

    @Test
    public void testALowerCaseLetter() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("a");
        assertEquals(1, scrabble.getScore());
    }

    @Test
    public void testAUpperCaseLetter() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("A");
        assertEquals(1, scrabble.getScore());
    }

    @Test
    public void testAValuableLetter() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("f");
        assertEquals(4, scrabble.getScore());
    }

    @Test
    public void testAShortWord() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("at");
        assertEquals(2, scrabble.getScore());
    }

    @Test
    public void testAShortValuableWord() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("zoo");
        assertEquals(12, scrabble.getScore());
    }

    @Test
    public void testAMediumWord() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("street");
        assertEquals(6, scrabble.getScore());
    }

    @Test
    public void testAMediumValuableWord() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("quirky");
        assertEquals(22, scrabble.getScore());
    }

    @Test
    public void testALongMixCaseWord() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("OxyphenButazone");
        assertEquals(41, scrabble.getScore());
    }

    @Test
    public void testAEnglishLikeWord() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("pinata");
        assertEquals(8, scrabble.getScore());
    }

    @Test
    public void testAnEmptyInput() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("");
        assertEquals(0, scrabble.getScore());
    }

    @Test
    public void testEntireAlphabetAvailable() {
        ScrabbleAlternativeSolution scrabble = new ScrabbleAlternativeSolution("abcdefghijklmnopqrstuvwxyz");
        assertEquals(87, scrabble.getScore());
    }

}
