package Examples.OOP.Others.class_use.local_class.local_class;

import java.util.ArrayList;
import java.util.List;

public class Handler {

    public void handle(String requestPath) {

        // interface Path{}
        // nemozet bit interface local

        class Path {
            List<String> parts = new ArrayList<String>();
            String path = "/";

            Path(String path) {
                if (path == null) return;
                this.path = path;
                for (String s : path.split("/"))
                    if (s.trim().length() > 0) this.parts.add(s);
            }

            int size() {
                return parts.size();
            }

            String get(int i) {
                return i > this.parts.size() - 1 ? null : this.parts.get(i);
            }

            boolean startsWith(String s) {
                return path.startsWith(s);
            }
        }

        Path path = new Path(requestPath);

        if (path.startsWith("/page")) {
            String pageId = path.get(1);

        }
        if (path.startsWith("/post")) {
            String categoryId = path.get(1);
            String postId = path.get(2);

        }

    }
}
