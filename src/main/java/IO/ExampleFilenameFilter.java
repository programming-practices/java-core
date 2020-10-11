package IO;

import java.io.File;
import java.io.FilenameFilter;

public class ExampleFilenameFilter {
    public static void main(String[] args) {
        String dirname = "src/main/resources/IO/DirectoryTest";
        File f1 = new File(dirname);
        FilenameFilter only = new OnlyExt(".html");
        String s[] = f1.list(only);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}

class OnlyExt implements FilenameFilter {
    String ext;

    public OnlyExt(String ext) {
        this.ext = ext;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

/*
Нередко требуется ограничить количество файлов, возвращаемых методом
l i s t ( ) , чтобы включить в их число только те файлы, которые соответствуют
определенному образцу имен, или фw�ътру. Для этого следует использовать вто­
рую форму метода l i s t ( ) , которая приведена ниже.
String [ ] list (FilenameFil ter FFOЬj)*/