package classLoader.tip113;

import java.net.URL;

/**
 * https://www.javaworld.com/article/2077468/java-tip-105--mastering-the-classpath-with-jwhich.html
 */
public class JWhich {
    /**
     * Prints the absolute pathname of the class file containing the specified
     * class name, as prescribed by the current classpath.
     * @param className Name of the class.
     */
    public static void which(String className) {
        if (!className.startsWith("/")) className = "/" + className;
        className = className.replace('.', '/');
        className = className + ".class";

        URL classUrl = new JWhich().getClass().getResource(className);

        if (classUrl != null) {
            System.out.println("\nClass '" + className +
                    "' found in \n'" + classUrl.getFile() + "'");
        } else {
            System.out.println("\nClass '" + className +
                    "' not found in \n'" + System.getProperty("java.class.path") + "'");
        }
    }

    public static void main(String args[]) {
        String className = "java.util.concurrent.DelayQueue";
        JWhich.which(className);
//        System.err.println("Usage: java JWhich <classname>");
    }
}