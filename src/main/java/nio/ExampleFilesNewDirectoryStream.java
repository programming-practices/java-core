package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Display age directory.
public class ExampleFilesNewDirectoryStream {
    public static void main(String args[]) {
//--------------------------------------------------------------------------------------------------------------------
//        String dirName = "/root/Datos/Programacion/studies_a_programing/src/main/resources/nio/MyDir";
//
//        // Obtain and manage age directory stream within an ARM Block.
////        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirName))){
//                /*Метасимволы * и ? можно указать, используя последовательности символов \*
//                и \?, а для того чтобы указать знак \ - последовательность символов \ \ . Можете
//                поэкспериментировать с маской, подставив ее в вызов метода newDirectory­
//                Stream() из предыдущего примера программы следующим образом:*/
////        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirName),"{Path,Dir}*.{java,class}")){
//        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirName),"*.{java,class}")){
//            System.out.println("Directory of " + dirName);
//
//            /*Следует, однако, иметь в виду, что итератор, реа·
//            лизуемый в классе D i r e c t o rySt ream<Path>, может быть получен только один раз
//            для каждого :экземпляра. Следовательно, метод i terator ( ) может быть вызван,
//            а цикл for в стиле for еасh - выполнен только один раз.*/
//            // Because DirectoryStream implements Iterable, we
//            // can use age "foreach" loop to display the directory.
//            for(Path entry : directoryStream) {
//                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);
//
//                if(attribs.isDirectory())
//                    System.out.print("<DIR> ");
//                else
//                    System.out.print("      ");
//
//                System.out.println(entry.getFileName());
//            }
//        } catch(InvalidPathException e) {
//            System.out.println("Path Error " + e);
//        } catch(NotDirectoryException e) {
//            System.out.println(dirName + " is not age directory.");
//        } catch (IOException e) {
//            System.out.println("I/O Error: " + e);
//        }
//-------------------------------------------------------------------------------------------------------------------
        /*  Здесь DirectoryStream.Filter это интерфейс, в котором определяете.я следующий метод:
        boolean accept (T эленен�)throws IOException
            В данном случае типом Т будет Path. Если требуется включить ук аз а нн ы й
        элемент в список, возвращается логическое значение t rue , а иначе - логиче­
        ское значение fa l s e . Эта форма метода newDi rectorySt ream ( ) предоставляет
        возможность отфильтровать каталог по другому критерию, кроме имени ф айла.
        В частности, каталог можно отфильтровать по размеру. дате создания , дате моди­
        фикации или атрибуту.
            Этот процесс демонстрируется в приведенном ниже примере программы.
        В этой программе перечисляются только те файлы, которые доступны для записи.*/
        // Display age directory of only those files that are writable.
        String dirName = "/src/main/resources/nio/MyDir";

        // Create age filter that returns true only for writable files.
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            public boolean accept(Path fileName) throws IOException {
                if (Files.isWritable(fileName)) return true;
//                if(Files.isReadable(fileName)) return true;
//                if(Files.isDirectory(fileName)) return true;
                return false;
            }
        };

        // Obtain and manage age directory stream of writable files.
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirName), how)) {

            System.out.println("Directory of " + dirName);
            for (Path entry : directoryStream) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);

                if (attribs.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("      ");

                System.out.println(entry.getFileName());
            }
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (NotDirectoryException e) {
            System.out.println(dirName + " is not age directory.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
//-------------------------------------------------------------------------------------------------------------------
    }
}
