import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        String actual = hamletParser.changeHamletToLeon();
        System.out.println(actual);

        Assert.assertFalse(actual.contains("Hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String actual = hamletParser.changeHoratioToTariq();
        System.out.println(actual);

        Assert.assertFalse(actual.contains("Horatio"));
    }

    @Test
    public void testFindHoratio() {
        String expected = "Horatio";
        String actual = hamletParser.findHoratio();
        System.out.println(actual);

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testFindHamlet() {

        boolean returned = hamletParser.findHamlet();

        Assert.assertTrue(returned);
    }
}