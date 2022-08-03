package classLoader.tip113;

import java.io.File;
import java.net.URL;

public class Launcher {
    public static void main(String[] args) {
        String packageName = "classLoader.tip113";
        if (args.length > 0) {
            try {
                Command command = (Command) Class.forName(packageName + "." + args[0]).newInstance();
                command.process();
            } catch (Exception ex) {
                System.out.println("Invalid command");
                System.out.println("Available commands:");
                find(packageName);
            }
        } else {
            System.out.println("Usage: Launcher <command>");
        }
    }

    static void find(String packageName) {
        // Translate the package name into an absolute path
        String name = packageName;
        if (!name.startsWith("/")) name = "/" + name;
        name = name.replace('.', '/');
        // Get a File object for the package
        URL url = Launcher.class.getResource(name);
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
                        Object o = Class.forName(packageName + "." + classname).newInstance();
                        if (o instanceof Command) System.out.println(classname);
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
}