import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {


    public static void main(String[] args) {
        HamletParser demo = new HamletParser();
        demo.changeFileHoratioToTariq();
        demo.changeFileHamletToLeon();


        try {
            FileWriter editor = new FileWriter("hamletremix.txt");
            editor.write(demo.getHamletData());
            editor.close();

        } catch (IOException e) {
            System.out.println("*blank stares* LINE!");
        }
    }

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
        Pattern pattern = Pattern.compile(bigHoratio, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        for (int i = 0; matcher.find(); i++) {
            indices.add(matcher.start());

        }
     return indices;
    }

    public List<String> findHorations(){
        List<String> horations = new ArrayList<>();
        Iterator<String> hamletIterator = Arrays.asList(hamletData.split("\n")).iterator();

        while (hamletIterator.hasNext()){
            Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(hamletIterator.next());
            if (matcher.find()) {
                String horation = matcher.group();
                horations.add(horation);
            }

        }
        return horations;

    }


    public String changeHoratioToTariq() {
        String replacement = "TARIQ";
        Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);

        return matcher.replaceAll(replacement);




    }

    public List<String> findHamlet() {
        List<String> hamletins = new ArrayList<>();
        Iterator<String> hamletIterator = Arrays.asList(hamletData.split("\n")).iterator();

        while (hamletIterator.hasNext()){
            Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(hamletIterator.next());
            if (matcher.find()) {
                String hamlet = matcher.group();
                hamletins.add(hamlet);
            }

        }
        return hamletins;
    }

    public List<Integer> findHamletIndices() {
        List<Integer>  indices = new ArrayList<>();

        String anyHamlet = "Hamlet";
        Pattern pattern = Pattern.compile(anyHamlet, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        for (int i = 0; matcher.find(); i++) {
            indices.add(matcher.start());

        }
        return indices;
    }

    public String changeHamletToLeon() {
        String replacement = "LEON";
        Pattern hamletPattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher hamMatcher = hamletPattern.matcher(hamletData);

        return hamMatcher.replaceAll(replacement);


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

    public synchronized void changeFileHoratioToTariq() {
        String replacement = "TARIQ";
        Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);

        this.hamletData = matcher.replaceAll(replacement);
    }

    public synchronized void changeFileHamletToLeon() {
        String replacement = "LEON";
        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);

        this.hamletData = matcher.replaceAll(replacement);
    }

}


