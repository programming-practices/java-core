package java_net;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ExampleHttpUtils {

    public static boolean isRequestEnd(byte[] request, int leng) {
        if (leng < 4) return false;

        return request[leng - 4] == '\r' &&
                request[leng - 3] == '\n' &&
                request[leng - 2] == '\r' &&
                request[leng - 1] == '\n';
    }

    public static byte[] readRequestFully(InputStream in) throws IOException {
        byte[] buff = new byte[8192];
        int headerLen = 0;
        while (true) {
            int count = in.read(buff, headerLen, buff.length - headerLen);
            if (count < 0) {
                throw new RuntimeException("Incoming connection close out not full HTTP header.");
            } else {
                headerLen += count;
                if (isRequestEnd(buff, headerLen)) {
                    return Arrays.copyOfRange(buff, 0, headerLen);
                }
                if (headerLen == buff.length) {
                    throw new RuntimeException("Too big HTML header. More than " + buff.length + "");
                }
            }
        }
    }

}
