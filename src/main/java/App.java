import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);
        ReaderCSVFile reader = new ReaderCSVFile();
        final String s = reader.readFileWithCSVLine(file);
        ParserCSVLine parser = new ParserCSVLine();
        System.out.println(parser.solution(s, args[1]));
    }
}
