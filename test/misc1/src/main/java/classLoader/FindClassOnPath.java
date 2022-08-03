package classLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.DelayQueue;

public class FindClassOnPath {
    public static void main(String[] args) {
        System.out.println(findFileOnJavaClassPath("slf4j-simple-1.7.30.jar"));
//        System.out.println(getTokens(";"));

    }

    public static Class getExpectedClass() {
        return new DelayQueue<>().getClass();
    }

    static File findFileOnJavaClassPath(final String fileName) {
        final String classpath = System.getProperty("java.class.path");
        final String pathSeparator = System.getProperty("path.separator");
        final StringTokenizer tokenizer = new StringTokenizer(classpath, pathSeparator);

        while (tokenizer.hasMoreTokens()) {
            final String pathElement = tokenizer.nextToken();
            final File directoryOrJar = new File(pathElement);
            final File absoluteDirectoryOrJar = directoryOrJar.getAbsoluteFile();

            if (absoluteDirectoryOrJar.isFile()) {
                final File target = new File(absoluteDirectoryOrJar.getParent(), fileName);
                if (target.exists()) {
                    return target;
                }
            } else {
                final File target = new File(directoryOrJar, fileName);
                if (target.exists()) {
                    return target;
                }
            }
        }
        return null;
    }

    static List<String> getTokens(String separator) {
        final String classpath = System.getProperty("java.class.path");
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(classpath, separator);
        while (tokenizer.hasMoreElements()) tokens.add(tokenizer.nextToken());
        return tokens;
    }
}
