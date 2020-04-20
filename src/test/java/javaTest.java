import com.bridgelabz.java.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.bridgelabz.java.ModelAnalysisException;
import org.junit.rules.ExpectedException;

public class javaTest {
    MoodAnalyzer moodAnalyzer;

    @Before
    public void initialization() {
        moodAnalyzer = new MoodAnalyzer(null);

    }

    @Test
    public void givenMoodeAnalyzer_shouldReturnHappy() {
        try {
            String happymood = moodAnalyzer.AnalyzeMood("I am in nod Mood");
            Assert.assertEquals("HAPPY", happymood);
        } catch (ModelAnalysisException e) {
            Assert.assertEquals(ModelAnalysisException.ExceptionType.ENTERED_NULL, e.type);

        }

    }

    @Test
    public void givenBadMoode_shouldReturnBad() {
        try {
            String badmoode = moodAnalyzer.AnalyzeMood("I am in BAD Mood");
            Assert.assertEquals("BAD", badmoode);
        } catch (ModelAnalysisException e) {
            Assert.assertEquals(ModelAnalysisException.ExceptionType.ENTERED_NULL, e.type);

        }

    }

    @Test
    public void givenNullMood_shouldReturnNull() {
        try {
            String mood = moodAnalyzer.AnalyzeMood("");
            System.out.println(mood);
            Assert.assertEquals("HAPPY", mood);
        } catch (ModelAnalysisException e) {
            Assert.assertEquals(ModelAnalysisException.ExceptionType.ENTERED_NULL, e.type);

        }
    }

    //custom exception for null
    @Test
    public void givenNullMoodShould_ReturnException() throws ModelAnalysisException {

        String mood;
        try {
            ExpectedException expectionRule = ExpectedException.none();
            expectionRule.expect(ModelAnalysisException.class);
            mood = moodAnalyzer.analyzeMood(null);
            Assert.assertEquals("HAPPY", mood);

        } catch (ModelAnalysisException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenMood_returnNull() {

        try {
            moodAnalyzer.AnalyzeMood(null);

        } catch (ModelAnalysisException e) {
            Assert.assertEquals(ModelAnalysisException.ExceptionType.ENTERED_NULL, e.type);

        }
    }
}


