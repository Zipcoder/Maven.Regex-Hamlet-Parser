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
        String actual = hamletParser.ChangeHamletToLeon();
        Assert.assertTrue(actual.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String actual = hamletParser.ChangeHoatioToTariq();
        Assert.assertTrue(actual.contains("Tariq"));
    }

    @Test
    public void testFindHoratio() {
        boolean actual = hamletParser.findHoratio();
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        boolean actual = hamletParser.findHamlet();
        Assert.assertTrue(actual);
    }
}