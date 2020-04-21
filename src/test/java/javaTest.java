import com.bridgelabz.java.MoodAnalyzer;
import com.bridgelabz.java.MoodAnalyzerFactory;
import jdk.nashorn.internal.codegen.FieldObjectCreator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.bridgelabz.java.ModelAnalysisException;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class javaTest {
    MoodAnalyzer moodAnalyzer;
    private FieldObjectCreator<Object> ObjectReflector;

    @Before
    public void initialization() {
        moodAnalyzer = new MoodAnalyzer(null);

    }
    //this is the reflection one type of implimentaion
    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyser("i m HAPPY mode");
        try {
          String mood=  moodAnalyzer.moodAnalys();
          Assert.assertEquals("HAPPY",mood);
        } catch (ModelAnalysisException e) {
            e.printStackTrace();
        }
    }
    //this is the reflection second type of implimentaion
    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelabz.java.MoodAnalyzer").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Object myObj = constructor.newInstance("im in bad mood");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) myObj;
            try {
                String mood = moodAnalyzer.moodAnalys();
                Assert.assertEquals("HAPPY", mood);
            } catch (ModelAnalysisException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
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

//    @Test
//    public void givenWrongClass_returnException() {
//
//      Object object=  ObjectReflector.createObject(className: "Testing", String valueParameter:"i m bad man");
//    }

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
    public void givenNullMoodThrowsException() {
        try {
//            ExpectedException expectionRule = ExpectedException.none();
//            expectionRule.expect(ModelAnalysisException.class);
            moodAnalyzer.AnalyzeMood(null);
        } catch (ModelAnalysisException e) {
            Assert.assertEquals("please enter proper mood", e.getMessage());
//            e.printStackTrace();
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


