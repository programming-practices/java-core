package generics.primesi_s_ispolzovaniem_interfeisov;

public class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    public long getSerialNumber() {
        return serialNumber;
    }
}
