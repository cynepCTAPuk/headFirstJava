package classLoader.tip113;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class Launcher2 {
    public static void main(String[] args) {
        find("java.util.Queue");
//        find("classLoader.tip113.Command");
    }

    static void find(String packageName, Class clazz) {
        String name = packageName;
        System.out.println(packageName);
        if (!name.startsWith("/")) name = "/" + name;
        name = name.replace('.', '/');
        System.out.println(name);
        URL url = Queue.class.getResource(name);
        System.out.println(url);
        if (url != null) {
            File directory = new File(url.getFile());
            if (directory.exists()) {
                System.out.println("packageName: " + packageName);
                System.out.println("name: " + name);
//                System.out.println("url: " + url);
                System.out.println("directory: " + directory);
                String[] files = directory.list();
                System.out.println(Arrays.toString(files));
                for (int i = 0; i < files.length; i++) {
                    if (files[i].endsWith(".class")) {
                        String className = files[i].substring(0, files[i].length() - 6);
                        try {
                            String classFullName = packageName + "." + className;
                            Object o = Class.forName(classFullName).newInstance();
                            if (clazz.isInstance(o)) System.out.println(o.getClass());
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//                        System.err.println(e);
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public static void find(String toSubClassName) {
        try {
            Class toSubClass = Class.forName(toSubClassName);
            Package[] packages = Package.getPackages();
            Arrays.sort(packages, Comparator.comparing(Package::getName));
            for (Package p : packages) {
//                System.out.println(p);
                find(p.getName(), toSubClass);
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Class " + toSubClassName + " not found!");
        }
    }
}