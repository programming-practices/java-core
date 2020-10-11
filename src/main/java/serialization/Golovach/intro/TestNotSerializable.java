package YouTube_Channels.Golovach_Courses.Java_Core_Serialization.intro;

import java.io.IOException;

public class TestNotSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] raw = SerUtils.objToByte(new NotSerializable());
        Object obj = SerUtils.byteToObject(raw);
    }
}
