package Examples.OOP.Others.class_use.adapter_classa;

import java.io.IOException;
import java.nio.CharBuffer;

public class AdapterHeneratorChar extends HeneratorChar implements Readable {

    @Override
    public int read(CharBuffer cb) throws IOException {
        return 0;
    }
}
