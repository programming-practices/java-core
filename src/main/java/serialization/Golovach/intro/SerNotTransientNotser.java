package YouTube_Channels.Golovach_Courses.Java_Core_Serialization.intro;

import java.io.Serializable;

public class SerNotTransientNotser implements Serializable {
    public NotSerializable notSer;

    public SerNotTransientNotser(NotSerializable notSer) {
        this.notSer = notSer;
    }
}
