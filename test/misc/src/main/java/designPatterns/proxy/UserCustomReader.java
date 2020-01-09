package designPatterns.proxy;

import java.io.IOException;
import java.io.Reader;

public class UserCustomReader extends Reader {
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        System.out.println("read(char[] cbuf, int off, int len)");
        return 0;
    }

    @Override
    public void close() throws IOException {
        System.out.println("close()");
    }
}
