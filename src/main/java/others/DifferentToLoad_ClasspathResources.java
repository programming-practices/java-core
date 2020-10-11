package others;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Sources: https://www.logicbig.com/how-to/java/different-ways-to-load-resources.html
 */
public class DifferentToLoad_ClasspathResources {

    private static final String line = "-----------------------------------------";

    public static void main(String[] args) throws IOException {

        DifferentToLoad_ClasspathResources a = new DifferentToLoad_ClasspathResources();
        List<String> list = new ArrayList<>();
        list.add("/home/trl/GitHub/LearnJava/core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("home/trl/GitHub/LearnJava/core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("/trl/GitHub/LearnJava/core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("trl/GitHub/LearnJava/core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("/GitHub/LearnJava/core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("GitHub/LearnJava/core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("/LearnJava/core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("LearnJava/core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("/core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("core/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("/src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("src/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("/main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("main/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("/resources/DifferentToLoad_ClasspathResources.txt");
        list.add("resources/DifferentToLoad_ClasspathResources.txt");
        list.add("/DifferentToLoad_ClasspathResources.txt");
        list.add("DifferentToLoad_ClasspathResources.txt");

//=====================================================================================================================

//        System.out.println(line + "\nusing this.getClass().getResource\n" + line);
//        a.loadResource("DifferentToLoad_ClasspathResources.txt");
//        a.loadResource("/DifferentToLoad_ClasspathResources.txt");
//        a.loadResource("root-resource.txt");
//        a.loadResource("/root-resource.txt");
//        a.loadResource("/file.txt");
//        a.loadResource("file.txt");
//        a.loadResource("/file2.txt");
//        a.loadResource("file2.txt");

//        System.out.println(line + "\n using current thread context loader\n" + line);
//        a.loadResourceWithContextLoader("DifferentToLoad_ClasspathResources.txt");
//        a.loadResourceWithContextLoader("/DifferentToLoad_ClasspathResources.txt");
//        a.loadResourceWithContextLoader("root-resource.txt");
//        a.loadResourceWithContextLoader("/root-resource.txt");
//        a.loadResourceWithContextLoader("/file.txt");
//        a.loadResourceWithContextLoader("file.txt");
//        a.loadResourceWithContextLoader("/file2.txt");
//        a.loadResourceWithContextLoader("file2.txt");

//        System.out.println(line + "\n using ClassLoader.getSystemClassLoader()\n" + line);
//        a.loadResourceWithSystemClassLoader("DifferentToLoad_ClasspathResources.txt");
//        a.loadResourceWithSystemClassLoader("/DifferentToLoad_ClasspathResources.txt");
//        a.loadResourceWithSystemClassLoader("root-resource.txt");
//        a.loadResourceWithSystemClassLoader("/root-resource.txt");
//        a.loadResourceWithSystemClassLoader("/file.txt");
//        a.loadResourceWithSystemClassLoader("file.txt");
//        a.loadResourceWithSystemClassLoader("/file2.txt");
//        a.loadResourceWithSystemClassLoader("file2.txt");

//=====================================================================================================================

        System.out.println(line + "\nusing this.getClass().getResource\n" + line);
        for (String url : list) {
            a.loadResource(url);
        }

        System.out.println(line + "\n using current thread context loader\n" + line);
        for (String url : list) {
            a.loadResourceWithContextLoader(url);
        }


        System.out.println(line + "\n using ClassLoader.getSystemClassLoader()\n" + line);
        for (String url : list) {
            a.loadResourceWithSystemClassLoader(url);
        }

//=====================================================================================================================

    }

    private void loadResource(String resource) throws IOException {
        URL u = this.getClass().getResource(resource);
        loadResourceByUrl(u, resource);
    }

    private void loadResourceWithContextLoader(String resource) throws IOException {
        URL u = Thread.currentThread().getContextClassLoader().getResource(resource);
        loadResourceByUrl(u, resource);
    }

    private void loadResourceWithSystemClassLoader(String resource) throws IOException {
        URL u = ClassLoader.getSystemClassLoader().getResource(resource);
        loadResourceByUrl(u, resource);
    }

    private void loadResourceByUrl(URL u, String resource) throws IOException {
        System.out.println("-> attempting input resource: " + resource);
        if (u != null) {
            String path = u.getPath();
            path = path.replaceFirst("^/(.:/)", "$1");
            System.out.println("    absolute resource path found :\n    " + path);
            String s = new String(Files.readAllBytes(Paths.get(path)));
            System.out.println("    file content: " + s);
        } else {
            System.out.println("    no resource found: " + resource);
        }
    }
}

