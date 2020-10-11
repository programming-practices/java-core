package others;

import java.io.*;
import java.util.Stack;

public class RewenieZadachSDywkami {
    private String path;

    public RewenieZadachSDywkami(String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        RewenieZadachSDywkami r = new RewenieZadachSDywkami("core/src/main/resources/RewenieZadachSDywkami.txt");
//        System.out.println(r.readFile());
        StringBuffer sbuffer = new StringBuffer("{)(){}[]([{}])}");
        System.out.println(sbuffer);
        System.out.println(r.check(sbuffer));
        System.out.println("-----------------------------");

        StringBuffer sbuffer2 = new StringBuffer("){(){}[]([{}])}");
        System.out.println(sbuffer2);
        System.out.println(r.check(sbuffer2));
        System.out.println("-----------------------------");

        StringBuffer sbuffer3 = new StringBuffer("(){}[]([{}])");
        System.out.println(sbuffer3);
        System.out.println(r.check(sbuffer3));
        System.out.println("-----------------------------");

        StringBuffer sbuffer4 = new StringBuffer("((([[[{{{()}}}]]])))");
        System.out.println(sbuffer4);
        System.out.println(r.check(sbuffer4));
        System.out.println("-----------------------------");

        StringBuffer sbuffer5 = new StringBuffer("((([[[{{{)}}}]]])))");
        System.out.println(sbuffer5);
        System.out.println(r.check(sbuffer5));
        System.out.println("-----------------------------");

        StringBuffer sbuffer6 = new StringBuffer("((([[[{{{}}}(]]])))");
        System.out.println(sbuffer6);
        System.out.println(r.check(sbuffer6));
        System.out.println("-----------------------------");

    }

    public StringBuffer readFile() {
        StringBuffer stringBuffer = new StringBuffer();
        int tmp;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            while ((tmp = br.read()) != -1) {
                stringBuffer.append((char) tmp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    private StringBuffer check(StringBuffer sb) {
        Stack<Character> stack = new Stack<>();
        for (char c : sb.toString().toCharArray()) {
            if (!stack.empty()) {
                if (stack.peek().equals('(') && c == ')' || stack.peek().equals('[') && c == ']' || stack.peek().equals('{') && c == '}') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else if (stack.empty()) {
                stack.push(c);
            }
        }

        sb = new StringBuffer();
        if (!stack.empty()) {
            for (Character c : stack) {
                sb.append(c);
            }
            return sb;
        } else {
            return sb.append("Vso xorowo vse duwki cowlis.");
        }
    }
}
