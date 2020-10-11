package YouTube_Channels.Golovach_Courses.Java_Core_Serialization.intro;

import java.io.IOException;

public class TestSerTransientNotser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerTransientNotser src = new SerTransientNotser(new NotSerializable());
        System.out.println(src.notSer);
        byte[] rew = SerUtils.objToByte(src);

        SerTransientNotser dst = (SerTransientNotser) SerUtils.byteToObject(rew);
        System.out.println(dst.notSer);
    }
}
