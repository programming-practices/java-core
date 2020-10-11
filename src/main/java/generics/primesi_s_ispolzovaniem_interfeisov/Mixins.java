package generics.primesi_s_ispolzovaniem_interfeisov;


interface Colored {
    public String getColor();

    public void setColor(String colorName);
}

class ColoredImp implements Colored {

    private String value = "name";

    @Override
    public String getColor() {
        return value;
    }

    @Override
    public void setColor(String colorName) {
        this.value = colorName;
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private Colored colored = new ColoredImp();

    public String getColored() {
        return colored.getColor();
    }

    public long getStamp() {
        return timeStamp.getStamp();
    }

    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}

public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin(), mixin3 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        mixin3.set("test string 2");
        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumber() + " " + mixin3.getColored());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumber() + " " + mixin3.getColored());
        System.out.println(mixin3.get() + " " + mixin3.getStamp() + " " + mixin3.getSerialNumber() + " " + mixin3.getColored());
    }
}
