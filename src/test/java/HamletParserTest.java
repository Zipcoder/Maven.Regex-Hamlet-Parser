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
        //given
        String expectedValue="His fell to Leon";
        String input="His fell to Hamlet";
        //when
        String actualValue=HamletParser.changeHamletToLeon(input);
        //then
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        String expectedValue="If you do meet Tariq and Marcellus";
        String input="If you do meet Horatio and Marcellus";
        //when
        String actualValue=HamletParser.changeHoratioToTariq(input);
        //then
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testFindHoratio() {
        boolean actualValue = HamletParser.findHoratio(hamletText);
        Assert.assertTrue(actualValue);
    }

    @Test
    public void testFindHamlet() {
        boolean actualValue=HamletParser.findHamlet(hamletText);
        Assert.assertTrue(actualValue);
    }
}