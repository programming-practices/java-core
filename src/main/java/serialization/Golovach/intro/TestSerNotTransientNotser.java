package YouTube_Channels.Golovach_Courses.Java_Core_Serialization.intro;

import java.io.IOException;

public class TestSerNotTransientNotser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] rew = SerUtils.objToByte(new SerNotTransientNotser(new NotSerializable()));
        Object obj = SerUtils.byteToObject(rew);
    }
}
