package regex.skanirovanie_s_ispolzyvaniem_rehylarnux_isklychennii;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyzer {
    static String threatData =
            "58.27.82.161@ 02/10/2005\n" +
                    "204.45.2 34.40@ 02/11/2005\n" +
                    "58.27. 82.161@ 02/11/2005\n" +
                    "58.27.82.161@ 02/12/2005\n" +
                    "58.27. 82.161@ 02/12/2005\n" +
                    "[Next log section with different data format]";

    public static void main(String[] args) {

        String[] sa = threatData.split("");
        StringBuilder sb = new StringBuilder();
        for (String s : sa) {
            if (!(" ".equals(s))) {
                sb.append(s);
            }

        }
//        System.out.println(sb);

        Scanner scanner = new Scanner(sb.toString());
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" + "(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.format("Threat on %s from %s\n", date, ip);
        }
    }
}
