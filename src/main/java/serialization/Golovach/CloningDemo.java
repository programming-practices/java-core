package YouTube_Channels.Golovach_Courses.Java_Core_Serialization;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CloningDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        {    // porozdenie suwchnosti
            Object[] src = {new Object[0]};
            Object[] dst = shallowCopy(src);
            System.out.println(src != dst);
            System.out.println(src.hashCode());
            System.out.println(src);
            System.out.println(dst.hashCode());
            System.out.println(dst);
            System.out.println("----------------------------------------------------------------------");

        }
        {    // poverxn. kopirovanie - ?????????????? hraf
            Object[] src = {new Object[0]};
            Object[] dst = shallowCopy(src);
            System.out.println(src[0] == dst[0]);
            System.out.println(src[0].hashCode());
            System.out.println(src[0]);
            System.out.println(dst[0].hashCode());
            System.out.println(dst[0]);
            System.out.println("----------------------------------------------------------------------");

        }
        {   // ne soxran. hraf obiektov
            Object[] src0 = {new Object[1]};
            Object[] src1 = {src0};
            src0[0] = src1;
            Object[] dst = shallowCopy(src0);
            System.out.println(((Object[]) dst[0])[0] != dst);
            System.out.println(((Object[]) dst[0])[0] == src0);
            System.out.println(dst[0].hashCode());
            System.out.println(dst[0]);
            System.out.println(dst);
            System.out.println(dst.hashCode());
            System.out.println("----------------------------------------------------------------------");
        }

    }

    public static <T extends Serializable> T shallowCopy(T obj) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = Object.class.getDeclaredMethod("clone");
        m.setAccessible(true);
        return (T) m.invoke(obj);
    }

}
