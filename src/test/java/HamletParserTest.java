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
        Pattern pattern = Pattern.compile("[H|h]amlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        String result = matcher.replaceAll("Leon");
        System.out.println(result);
    }

    @Test
    public void testChangeHoratioToTariq() {
        Pattern pattern = Pattern.compile("[H|h]oratio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        String result = matcher.replaceAll("Tariq");
        System.out.println(result);
    }

    @Test
    public void testFindHoratio() {
        Boolean expected = true;

        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        Boolean actual = matcher.find();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        Boolean expected = true;

        Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        Boolean actual = matcher.find();

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = AssertionError.class)
    public void testFindARegexNotThere_Failure() {
        Boolean expected = true;

        Pattern pattern = Pattern.compile("AppleBottomJeans", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        Boolean actual = matcher.find(0);

        Assert.assertEquals(expected, actual);
    }
}