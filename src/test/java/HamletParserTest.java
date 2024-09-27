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
        //Action
        String actual = hamletParser.changeHamletToLeon();
        System.out.println(actual);

        //Assert
        Assert.assertFalse(actual.contains("Hamlet"));
        Assert.assertFalse(actual.contains("hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Action
        String actual = hamletParser.changeHoratioToTariq();
        System.out.println(actual);

        //Assert
        Assert.assertFalse(actual.contains("Horatio"));
        Assert.assertFalse(actual.contains("horatio"));
    }

    @Test
    public void testFindHoratio() {
        //Action
        boolean actual = hamletParser.findHoratio();

        //Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        //Action
        boolean actual = hamletParser.findHamlet();

        //
        Assert.assertTrue(actual);
    }
}