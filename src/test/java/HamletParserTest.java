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
        //when
        String result = hamletParser.changeHamletToLeon(hamletText);
        //then
        Assert.assertFalse(hamletParser.findHamlet(result));
        System.out.println(result);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //when
        String result = hamletParser.changeHoratioToTariq(hamletText);
        //then
        Assert.assertFalse(hamletParser.findHoratio(result));
        System.out.println(result);
    }

    @Test
    public void testFindHoratio() {
        //when
        boolean actual = hamletParser.findHoratio(hamletText);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        //when
        boolean actual = hamletParser.findHamlet(hamletText);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testNewHamletText() throws InterruptedException {
        //when
        String result = hamletParser.changeHamletText(hamletText);
        //then
        Assert.assertFalse(hamletParser.findHamlet(result));
        Assert.assertFalse(hamletParser.findHoratio(result));
        System.out.println(result);
    }
}