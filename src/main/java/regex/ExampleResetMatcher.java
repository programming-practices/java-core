package Examples.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleResetMatcher {
    public static void main(String[] args) throws Exception {
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");

        while (m.find()) System.out.print(m.group() + " ");

        System.out.println();

        m.reset("fix the rig with rags");
        while (m.find()) System.out.print(m.group() + " ");

        System.out.println();

        m.reset("fux the rag with fags");
        while (m.find()) System.out.print(m.group() + " ");

        System.out.println();

        m.reset();
        while (m.find()) System.out.print(m.group() + " ");
    }
}
