import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public boolean findHamlet() {
        if (hamletData.contains("Hamlet")) {
            return true;
        }
        return false;
    }

    public boolean findHoratio() {
        if (hamletData.contains("Horatio")) {
            return true;
        }
        return false;
    }

    public void changeHamletToLeon() {
        Matcher matcher = matchHamlet();
        hamletData = matcher.replaceAll("Leon");
    }

    public void changeHoratioToTariq() {
        Matcher matcher = matchHoratio();
        hamletData = matcher.replaceAll("Tariq");
    }

    public Matcher matchHamlet() {
        return Pattern.compile("(?i)Hamlet").matcher(hamletData);
    }

    public Matcher matchHoratio() {
        return Pattern.compile("(?i)Horatio").matcher(hamletData);
    }

    public void changeFile() throws IOException {
        FileWriter fileWriter = new FileWriter("/Users/zach/dev/Maven.Regex-Hamlet-Parser/src/main/resources/hamlet.txt");
        changeHoratioToTariq();
        changeHamletToLeon();
        fileWriter.write(hamletData);
        fileWriter.close();
    }
}
