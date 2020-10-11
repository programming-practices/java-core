package generics.primesi_s_ispolzovaniem_interfeisov;

import java.util.Date;

class BasicD {
    private String value;

    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}

class Decorator extends BasicD {
    protected BasicD basicD;

    public Decorator(BasicD basicD) {
        this.basicD = basicD;
    }

    public void set(String val) {
        basicD.set(val);
    }

    public String get() {
        return basicD.get();
    }
}

class TimeStampedD extends Decorator {
    private final long timeStamp;

    public TimeStampedD(BasicD basicD) {
        super(basicD);
        timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumberedD extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    public SerialNumberedD(BasicD basicD) {
        super(basicD);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}

public class Decoration {
    public static void main(String[] args) {
        TimeStampedD t = new TimeStampedD(new BasicD());
        TimeStampedD t2 = new TimeStampedD(new SerialNumberedD(new BasicD()));
        //! t2.getSerialNumber(); // Not available
        SerialNumberedD s = new SerialNumberedD(new BasicD());
        SerialNumberedD s2 = new SerialNumberedD(new TimeStampedD(new BasicD()));
        //! s2.getStamp(); // Not available
    }
}
