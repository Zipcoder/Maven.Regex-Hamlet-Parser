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
        Pattern pattern = Pattern.compile("Hamlet",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        String result = matcher.replaceAll("Leon");
        System.out.println(result);

    }

    @Test
    public void testChangeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        String result = matcher.replaceAll("Tariq");
        System.out.println(result);
    }

    @Test
    public void testFindHoratio() {
        Pattern pattern = Pattern.compile("Horatio",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        boolean actual = matcher.find(0);
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        Pattern pattern = Pattern.compile("Hamlet",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);
        boolean actual = matcher.find(0);
        Assert.assertTrue(actual);
    }
}
