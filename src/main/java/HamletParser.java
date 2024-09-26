import java.io.File;
import java.io.IOException;
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

    public static String changeHamletToLeon(String input){
        Pattern pattern=Pattern.compile("Hamlet",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(input);
        return matcher.replaceAll("Leon");
    }

    public static String changeHoratioToTariq(String input){
        Pattern pattern=Pattern.compile("Horatio",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(input);
        return matcher.replaceAll("Tariq");
    }

    public static boolean findHoratio(String input){
        Pattern pattern=Pattern.compile("Horatio",Pattern.CASE_INSENSITIVE);
        Matcher matcher= pattern.matcher(input);
        if(matcher.find())
            return true;
        return false;
    }

    public static boolean findHamlet(String input){
        Pattern pattern=Pattern.compile("Hamlet");
        Matcher matcher= pattern.matcher(input);
        if(matcher.find())
            return true;
        return false;
    }

}
