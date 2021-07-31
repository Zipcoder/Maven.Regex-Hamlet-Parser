import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> findHoratio() {
        List<Integer>  indices = new ArrayList<>();

        String bigHoratio = "HORATIO";
        Pattern pattern = Pattern.compile(bigHoratio);
        Matcher matcher = pattern.matcher(hamletData);
        for (int i = 0; matcher.find(); i++) {
            indices.add(matcher.start());

        }
     return indices;
    }

    public List<Integer> findTariq() {
        List<Integer>  indices = new ArrayList<>();

        String bigTariq = "TARIQ";
        Pattern pattern = Pattern.compile(bigTariq);
        Matcher matcher = pattern.matcher(hamletData);
        for (int i = 0; matcher.find(); i++) {
            indices.add(matcher.start());

        }
        return indices;
    }

    public void changeHoratioToTariq() {


        }
    }

