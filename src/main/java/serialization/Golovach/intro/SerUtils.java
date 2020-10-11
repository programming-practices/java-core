package YouTube_Channels.Golovach_Courses.Java_Core_Serialization.intro;

import java.io.*;

public class SerUtils {
    public static byte[] objToByte(Object obj) throws IOException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(buff);
        out.writeObject(obj);
        out.flush();
        out.close();
        return buff.toByteArray();
    }

    public static Object byteToObject(byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(bytes));
        return in.readObject();
    }
}
