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
        String answer = hamletParser.replaceString(hamletText,"Hamlet","leon");
        //when
        Boolean actualFalse = hamletParser.findPattern(answer,"Hamlet");
        Boolean actualTrue = hamletParser.findPattern(answer,"Leon");
        //then
        Assert.assertFalse(actualTrue);
        Assert.assertFalse(actualFalse);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        String answer = hamletParser.replaceString(hamletText,"Horatio","Tariq");
        //When
        Boolean actualFalse = hamletParser.findPattern(answer,"Horatio");
        Boolean actualTrue = hamletParser.findPattern(answer,"Tariq");
        //Then
        Assert.assertFalse(actualFalse);
        Assert.assertTrue(actualTrue);
    }

    @Test
    public void testFindHoratio() {
        Boolean actual = hamletParser.findPattern(this.hamletText,"Horatio");
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        Boolean actual = hamletParser.findPattern(this.hamletText,"Hamlet");
        Assert.assertTrue(actual);
    }
}