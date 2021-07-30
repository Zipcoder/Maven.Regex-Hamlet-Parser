import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        String result = hamletParser.replaceString(hamletText,"Hamlet","Leon");
        //when
        Boolean actualFalse  = hamletParser.findPattern(result,"Hamlet");
        Boolean actualTrue  = hamletParser.findPattern(result,"Leon");
        //then
        Assert.assertFalse(actualFalse);
        Assert.assertFalse(actualTrue);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        String result = hamletParser.replaceString(hamletText,"Horatio","Tariq");
        //when
        Boolean actualFalse  = hamletParser.findPattern(result,"Horatio");
        Boolean actualTrue  = hamletParser.findPattern(result,"Tariq");
        //then
        Assert.assertFalse(actualFalse);
        Assert.assertTrue(actualTrue);
    }

    @Test
    public void testFindHoratio() {
        Boolean actual  = hamletParser.findPattern(this.hamletText,"Horatio");

        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        Boolean actual  = hamletParser.findPattern(this.hamletText,"Hamlet");

        Assert.assertTrue(actual);
    }
}