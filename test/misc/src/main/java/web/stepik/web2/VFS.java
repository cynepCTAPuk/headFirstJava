package web.stepik.web2;

import java.util.Iterator;

public interface VFS {
    boolean isExist(String path);
    boolean isDirectory(String path);
    String getAbsolutePath(String file);
    byte[] getBytes(String file);
    String getUTF8Text(String file);
    Iterator<String> getIterator(String startDir);
}
