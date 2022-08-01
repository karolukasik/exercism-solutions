import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {

    private WordCount wordCount;
    private Map<String, Long> actualWordCount;
    private Map<String, Long> expectedWordCount;

    @Before
    public void setup() {
        wordCount = new WordCount();
        expectedWordCount = new HashMap<>();
    }

    @Test
    public void countOneWord() {
        expectedWordCount.put("word", (long) 1);

        actualWordCount = wordCount.phrase("word");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void countOneOfEachWord() {
        expectedWordCount.put("one", (long) 1);
        expectedWordCount.put("of", (long) 1);
        expectedWordCount.put("each", (long) 1);

        actualWordCount = wordCount.phrase("one of each");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void multipleOccurrencesOfAWord() {
        expectedWordCount.put("one", (long) 1);
        expectedWordCount.put("fish", (long) 4);
        expectedWordCount.put("two", (long) 1);
        expectedWordCount.put("red", (long) 1);
        expectedWordCount.put("blue", (long) 1);

        actualWordCount = wordCount.phrase("one fish two fish red fish blue fish");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void handlesCrampedLists() {
        expectedWordCount.put("one", (long)1);
        expectedWordCount.put("two", (long)1);
        expectedWordCount.put("three", (long)1);

        actualWordCount = wordCount.phrase("one,two,three");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void handlesExpandedLists() {
        expectedWordCount.put("one", (long)1);
        expectedWordCount.put("two", (long)1);
        expectedWordCount.put("three", (long)1);

        actualWordCount = wordCount.phrase("one,\ntwo,\nthree");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void ignorePunctuation() {
        expectedWordCount.put("car", (long) 1);
        expectedWordCount.put("carpet", (long) 1);
        expectedWordCount.put("as", (long) 1);
        expectedWordCount.put("java", (long) 1);
        expectedWordCount.put("javascript", (long) 1);

        actualWordCount = wordCount.phrase("car : carpet as java : javascript!!&@$%^&");
        assertEquals(
                expectedWordCount, actualWordCount);

    }


    @Test
    public void includeNumbers() {
        expectedWordCount.put("testing", (long) 2);
        expectedWordCount.put("1", (long) 1);
        expectedWordCount.put("2", (long) 1);

        actualWordCount = wordCount.phrase("testing, 1, 2 testing");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void normalizeCase() {
        expectedWordCount.put("go", (long) 3);
        expectedWordCount.put("stop", (long) 2);

        actualWordCount = wordCount.phrase("go Go GO Stop stop");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void withApostrophes() {
        expectedWordCount.put("first", (long) 1);
        expectedWordCount.put("don't", (long) 2);
        expectedWordCount.put("laugh", (long) 1);
        expectedWordCount.put("then",(long)  1);
        expectedWordCount.put("cry", (long) 1);

        actualWordCount = wordCount.phrase("First: don't laugh. Then: don't cry.");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void substringsFromTheBeginning() {
        expectedWordCount.put("joe", (long)1);
        expectedWordCount.put("can't", (long)1);
        expectedWordCount.put("tell", (long)1);
        expectedWordCount.put("between", (long)1);
        expectedWordCount.put("app", (long)1);
        expectedWordCount.put("apple", (long)1);
        expectedWordCount.put("and", (long)1);
        expectedWordCount.put("a", (long)1);

        actualWordCount = wordCount.phrase("Joe can't tell between app, apple and a.");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void withQuotations() {
        expectedWordCount.put("joe", (long)1);
        expectedWordCount.put("can't", (long)1);
        expectedWordCount.put("tell", (long)1);
        expectedWordCount.put("between", (long)1);
        expectedWordCount.put("large", (long)2);
        expectedWordCount.put("and", (long)1);

        actualWordCount = wordCount.phrase("Joe can't tell between 'large' and large.");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void multipleSpacesNotDetectedAsAWord() {
        expectedWordCount.put("multiple", (long)1);
        expectedWordCount.put("whitespaces", (long)1);

        actualWordCount = wordCount.phrase(" multiple   whitespaces");
        assertEquals(
                expectedWordCount, actualWordCount);
    }


    @Test
    public void alternatingWordSeperatorsNotDetectedAsAWord() {
        expectedWordCount.put("one", (long)1);
        expectedWordCount.put("two", (long)1);
        expectedWordCount.put("three", (long)1);

        actualWordCount = wordCount.phrase(",\n,one,\n ,two \n 'three'");
        assertEquals(
                expectedWordCount, actualWordCount);
    }

}
