package classLoader;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

public class ClassFinder1 {
    private static final char PKG_SEPARATOR = '.';
    private static final char DIR_SEPARATOR = '/';
    private static final String CLASS_FILE_SUFFIX = ".class";
    private static final String BAD_PACKAGE_ERROR =
            "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

    public static void main(String[] args) throws URISyntaxException {
        Queue queue;
        DelayQueue delayQueue;
        // пример поиска ClassFinder.find("com.myproject.java", "Hello");
        List<Class<?>> classes = ClassFinder1.find("java.util","Queue");
        for (Class item : classes) System.out.println(item.getName());
    }

    static List<Class<?>> find(String scannedPackage, String beginStr)
            throws URISyntaxException {
        String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
        System.out.println(scannedPath);
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException(
                    String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
        }

        File scannedDir = new File(scannedUrl.toURI());

        List<Class<?>> classes = new ArrayList<Class<?>>();
        for (File file : scannedDir.listFiles()) {
            classes.addAll(find(file, scannedPackage, beginStr));
        }
        return classes;
    }

    private static List<Class<?>> find(File file, String scannedPackage, String beginStr) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String resource = scannedPackage + PKG_SEPARATOR + file.getName();
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                classes.addAll(find(child, resource, beginStr));
            }
        } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
            int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
            String className = resource.substring(0, endIndex);
            try {
                Class foundedClass = Class.forName(className);
                String[] bits = foundedClass.getName().split("\\.");
                String lastOne = bits[bits.length - 1];

                if (lastOne.toLowerCase()
                        .substring(0, beginStr.length()).equals(beginStr.toLowerCase()))
                    classes.add(foundedClass);
            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }
}