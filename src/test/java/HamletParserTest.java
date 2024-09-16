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
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletText);
        String finalResult = matcher.replaceAll("Leon");

        System.out.println(finalResult);
        Boolean hasHamlet = finalResult.indexOf("Hamlet") != -1;

        Assert.assertFalse(hasHamlet);
    }

    @Test
    public void testChangeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletText);
        String finalResult = matcher.replaceAll("Tariq");

        System.out.println(finalResult);
        Boolean hasHoratio = finalResult.indexOf("Horatio") != -1;

        Assert.assertFalse(hasHoratio);
    }

    @Test
    public void testFindHoratio() {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletText);
        Integer count = 0;

        while (matcher.find()){
            count++;
        }
        System.out.println(count);
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testFindHamlet() {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletText);
        Integer count = 0;

        while(matcher.find()){
            count++;
        }
        System.out.println(count);
        Assert.assertTrue(count > 0);
    }
}