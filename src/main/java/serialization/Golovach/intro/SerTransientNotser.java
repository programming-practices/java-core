package YouTube_Channels.Golovach_Courses.Java_Core_Serialization.intro;

import java.io.Serializable;

public class SerTransientNotser implements Serializable {
    public transient NotSerializable notSer;

    public SerTransientNotser(NotSerializable notSer) {
        this.notSer = notSer;
    }
}
