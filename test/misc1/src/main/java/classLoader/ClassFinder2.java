package classLoader;
/**
 * Поиск класса по его части его имени Java
 */

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

public class ClassFinder2 {
    public static void main (String[] args) throws java.lang.Exception  {
        // пример поиска ClassFinder.find("com.myproject.java", "Hello");
        List<Class> classes = ClassFinder2.find("java.utit", "Queue");

        for (Class item : classes) System.out.println(item.getName());
    }

    public static List<Class> find(String packageName, String beginStr) {
        List<Class> classes = new ArrayList<Class>();
        File directory = null;
        String relPath = packageName.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);

        if (resource == null) {
            throw new RuntimeException("No resource for " + relPath);
        }

        try {
            directory = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(packageName + " (" + resource + ") does not appear to be a valid URL / URI.  Strange, since we got it from the system...", e);
        } catch (IllegalArgumentException e) {
            directory = null;
        }

        if (directory != null && directory.exists()) {
            // Get the list of the files contained in the package
            String[] files = directory.list();
            for (int i = 0; i < files.length; i++) {
                // we are only interested in .class files
                if (files[i].endsWith(".class")) {
                    // removes the .class extension
                    String className = files[i].substring(0, files[i].length() - 6);

                    if (className.toLowerCase().substring(0, beginStr.length()).equals(beginStr.toLowerCase())) {
                        String fullClassName = packageName + '.' + className;
                        try {
                            classes.add(Class.forName(fullClassName));
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException("ClassNotFoundException loading " + fullClassName);
                        }
                    }
                }
            }
        }
        return classes;
    }
}