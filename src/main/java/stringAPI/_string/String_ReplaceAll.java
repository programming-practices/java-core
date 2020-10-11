package stringAPI._string;

public class String_ReplaceAll {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        System.out.println("' H E      L  L O '".replaceAll("\\s+", ""));


//---------------------------------------------------------------------------------------------------------------------

        // Let's see an example to replace all the occurrences of a single character.
        String s1 = "java is a very good language programing";
        String s2 = "Hello World";
        String replaceString = s1.replaceAll("a", "Y");//replaces all occurrences of "a" to "e"
        String replaceString2 = s2.replaceAll("(?i)[^aeiou]", "");
//        System.out.println(replaceString);

//---------------------------------------------------------------------------------------------------------------------

//        // Let's see an example to replace all the occurrences of single word or set of words.
//        String s1 = "My name is Khan. My name is Bob. My name is Sonoo.";
//        String replaceString = s1.replaceAll("is","was");//replaces all occurrences of "is" to "was"
//        System.out.println(replaceString);

//---------------------------------------------------------------------------------------------------------------------

//        // Let's see an example to remove all the occurrences of white spaces.
//        String s1="My name is Khan. My name is Bob. My name is Sonoo.";
//        String replaceString=s1.replaceAll("\\s","");
//        System.out.println(replaceString);

//---------------------------------------------------------------------------------------------------------------------
    }
}
