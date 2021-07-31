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
    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        String expected = "TARIQ";

        //when
        hamletParser.changeHoratioToTariq();
        List<Integer> indices = hamletParser.findTariq();
        int tarIndex = indices.get(0);

        //then
        String actual = hamletText.substring(tarIndex, tarIndex+6);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHoratio() {
            //given
            String text = hamletText;
            String expected = "HORATIO";
//            String[] splitText = hamletText.split("\n");
//            List<String> horations = Arrays.stream(splitText)
//                .filter(val-> val.matches("HORATIO"))
//                .collect(Collectors.toList());


            //when
            List<Integer> indices = hamletParser.findHoratio();
            //Assert.assertEquals(horations.size(), indices.size());
            int horIndex = indices.get(77);

            //then
            String actual = hamletText.substring(horIndex, horIndex+7);
            Assert.assertEquals(expected, actual);






//        //given
//        String[] splitText = hamletText.split("\n");
//        int horatioCount = 0;
//
//        //when
//
//
//        for (String s : splitText) {
//            if (s.matches("(Horatio)|(HORATIO)")){
//                horatioCount++;
//            }
//        }
//
//        //then
//        int actual = horations.size();
//        int expected = horatioCount;
//        Assert.assertEquals(expected, actual);




    }

    @Test
    public void testFindHamlet() {
    }
}