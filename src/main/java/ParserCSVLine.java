import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParserCSVLine {

    private static final Logger LOG = LogManager.getLogger(ParserCSVLine.class);

    public int solution(String s, String c) {

        if (s == null || c == null) {
            LOG.info("Enter line and column name");
        }

        String [] rows = s.split("\\\\n");
        for (String row : rows) {
            System.out.println(row);
        }
        System.out.println(rows[0].split(",").toString());
        final String[] columnNames = rows[0].split(",");
        int columnNumber = 0;
        for (int i = 0; i < columnNames.length; i++) {
            if (c.equals(columnNames[i])) {
                columnNumber = i;
            }
        }
        System.out.println(columnNumber);

        List<Integer> results = new ArrayList<>();
        for (int i = 1; i < rows.length; i++) {
            final String[] data = rows[i].split(",");
            String numberString = data[columnNumber];
            int number = 0;
            if (numberString.contains("−")) {
                numberString = numberString.replaceAll("−", "");
                number = Integer.parseInt(numberString) * (-1);
            } else {
                number = Integer.parseInt(numberString);
            }
            results.add(number);
        }

        return results.stream()
                .max(Integer::compareTo).get();
    }
}
