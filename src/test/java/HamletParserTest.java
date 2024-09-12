import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        String expected = "LEON";
        List<Integer> indices = hamletParser.findHamletIndices();

        //when
        String altered = hamletParser.changeHamletToLeon();
        int leonIndex = indices.get(0);

        //then
        Assert.assertFalse(hamletText.equals(altered));
        String actual = altered.substring(leonIndex, leonIndex+4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        String expected = "TARIQ";
        List<Integer> indices = hamletParser.findHoratio();

        //when
        String altered = hamletParser.changeHoratioToTariq();
        int tarIndex = indices.get(0);

        //then
        assertNotEquals(hamletText, altered);
        String actual = altered.substring(tarIndex, tarIndex+5);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHoratioIndices() {
        //given
        String expected = "HORATIO";


        //when
        List<Integer> indices = hamletParser.findHoratio();
        int horIndex = indices.get(77);

        //then
        String actual = hamletText.substring(horIndex, horIndex + 7);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findHoratioStrings(){
        //given
        List<String> find = hamletParser.findHorations();
        List<Integer> indices = hamletParser.findHoratio();

        Assert.assertEquals(find.size(), indices.size());
    }


    @Test
    public void testFindHamlet() {
        //given
        String expected = "HAMLET";
        List<String> hamlets = hamletParser.findHamlet();

        //when
        String actual = hamlets.get(0).toUpperCase();

        //then
        Assert.assertEquals(expected, actual);
    }
}