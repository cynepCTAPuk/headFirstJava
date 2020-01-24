package classLoader.task3507_1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/*
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Set<? extends Animal> allAnimals = getAllAnimals(
                Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath()
                        + Solution.class.getPackage().getName().replaceAll("[.]", "/")
                        + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals)
            throws IOException, ClassNotFoundException {
        Set set = new HashSet();
        File[] files = new File(pathToAnimals).listFiles();

        for (File file : files) {
            if (file.isFile() && file.toString().endsWith(".class")) {
                String packageName = Solution.class.getPackage().getName() + ".data.";
                String className = file.getName().replace(".class", "");

                URL classUrl = new URL("file:///" + file.getCanonicalPath());
                URL[] classUrls = {classUrl};
                URLClassLoader ucl = new URLClassLoader(classUrls);

                Class clazz = ucl.loadClass(packageName + className);
                if (Arrays.toString(clazz.getInterfaces()).contains("Animal")) {
                    try {
                        Animal animal = (Animal) clazz.newInstance();
                        set.add(animal);
                    } catch (InstantiationException | IllegalAccessException e) {
                    }
                }
            }
        }
        return set;
    }
}
