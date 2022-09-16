package classLoader.tip113;
/**
 * https://www.javaworld.com/article/2077477/java-tip-113--identify-subclasses-at-runtime.html
 */

import java.io.File;
import java.net.URL;

public class Launcher1 {
    public static void main(String[] args) {
        String packageName = "classLoader.tip113";
        String className = "DoorCl";
        try {
            Command command = (Command) Class.forName(packageName + "." + className).newInstance();
            command.process();
        } catch (Exception ex) {
            System.out.println("Invalid command");
            System.out.println("Available commands:");
            find(packageName, Command.class);
        }
    }

    static void find(String packageName, Class clazz) {
        // Translate the package name into an absolute path
        String name = packageName;
        if (!name.startsWith("/")) name = "/" + name;
        name = name.replace('.', '/');
        // Get a File object for the package
        URL url = Launcher1.class.getResource(name);
        File directory = new File(url.getFile());
        if (directory.exists()) {
            // Get the list of the files contained in the package
            String[] files = directory.list();
            for (int i = 0; i < files.length; i++) {
                // we are only interested in .class files
                if (files[i].endsWith(".class")) {
                    // removes the .class extension
                    String classname = files[i].substring(0, files[i].length() - 6);
                    try {
                        // Try to create an instance of the object
//                        System.out.println(packageName);
                        Object o = Class.forName(packageName + "." + classname).newInstance();
                        if (clazz.isInstance(o)) System.out.println(classname);
                    } catch (ClassNotFoundException cnfex) {
                        System.err.println(cnfex);
                    } catch (InstantiationException iex) {
                        // We try to instantiate an interface
                        // or an object that does not have a default constructor
                    } catch (IllegalAccessException iaex) {
                        // The class is not public
                    }
                }
            }
        }
    }

    public static void find(String tosubclassname) {
        try {
            Class tosubclass = Class.forName(tosubclassname);
            Package[] pcks = Package.getPackages();
            for (int i = 0; i < pcks.length; i++) {
                find(pcks[i].getName(), tosubclass);
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Class " + tosubclassname + " not found!");
        }
    }
}