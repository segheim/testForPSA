import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderCSVFile {

    private static final Logger LOG = LogManager.getLogger(ReaderCSVFile.class);

    public String readFileWithCSVLine(File file) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = bufferedReader.readLine()) != null){
                if (!line.contains("+")) {
                    Pattern pattern = Pattern.compile("[A-Za-z0-9-]+");
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        stringBuilder.append(matcher.group()).append(",");
                    }
                    stringBuilder.append("\\n");
                }
            }
        } catch(FileNotFoundException e){
            LOG.error("File for read not found!");
        }
        return stringBuilder.toString();
    }

}
