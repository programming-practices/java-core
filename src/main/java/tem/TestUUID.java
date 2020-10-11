package tem;

import java.util.UUID;

public class TestUUID {
    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        System.out.println("Random UUID String = " + id);
        System.out.println("UUID version       = " + id.version());
        System.out.println("UUID variant       = " + id.variant());
        System.out.println(id.getLeastSignificantBits());
        System.out.println(id.getMostSignificantBits());
        System.out.println(UUID.fromString(id.toString()));
    }
}
