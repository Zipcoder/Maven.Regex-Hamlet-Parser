import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        // When
        hamletParser.changeHamletToLeon();
        boolean hasHamlet = hamletParser.findHamlet();

        // Then
        Assert.assertFalse(hasHamlet);
    }

    @Test
    public void testChangeHoratioToTariq() {
        // When
        hamletParser.changeHoratioToTariq();
        boolean hasHoratio = hamletParser.findHoratio();

        // Then
        Assert.assertFalse(hasHoratio);
    }

    @Test
    public void testFindHoratio() {
        // Given
        boolean expected = Pattern.compile("(?i)Horatio").matcher(hamletText).find();

        // When
        boolean actual = hamletParser.findHoratio();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        // Given
        boolean expected = Pattern.compile("(?i)Hamlet").matcher(hamletText).find();

        // When
        boolean actual = hamletParser.findHamlet();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMatchHamlet() {
        // Given
        String expectedMatcher = Pattern.compile("(?i)Hamlet").matcher(hamletText).toString();

        // When
        String actualMatcher = hamletParser.matchHamlet().toString();

        // Then
        Assert.assertEquals(expectedMatcher, actualMatcher);
    }

    @Test
    public void testMatchHoratio() {
        // Given
        String expectedMatcher = Pattern.compile("(?i)Horatio").matcher(hamletText).toString();

        // When
        String actualMatcher = hamletParser.matchHoratio().toString();

        // Then
        Assert.assertEquals(expectedMatcher, actualMatcher);
    }
}