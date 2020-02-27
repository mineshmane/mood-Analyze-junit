import com.bridgelabz.java.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class javaTest {
    MoodAnalyzer moodAnalyzer;

    @Before
    public void initialization() {
        moodAnalyzer = new MoodAnalyzer();

    }

    @Test
    public void givenMoodeAnalyzer_shouldReturnHappy() {
        String happymood = moodAnalyzer.happymood("HAPPY");
        Assert.assertEquals("HAPPY", happymood);
    }

    @Test
    public void givenBadMoode_shouldReturnBad() {

        String badmoode = moodAnalyzer.happymood("BAD");
        Assert.assertEquals("BAD",badmoode);
    }

    @Test
    public void givenNullMood_shouldReturnNull(){
        String mood = moodAnalyzer.happymood(null);
        System.out.println(mood);
        Assert.assertEquals("HAPPY",mood);
    }
}
