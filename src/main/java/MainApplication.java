import java.io.FileNotFoundException;
import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        HamletParser parser = new HamletParser();
        parser.changeFile();
    }
}
