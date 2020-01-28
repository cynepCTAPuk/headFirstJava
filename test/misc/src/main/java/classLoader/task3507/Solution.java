package classLoader.task3507;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/*
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {
        Set<? extends Animal> allAnimals = getAllAnimals(
                Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath()
                        + Solution.class.getPackage().getName().replaceAll("[.]", "/")
                        + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException {
        Set<Animal> set = new HashSet();
        File[] files = new File(pathToAnimals).listFiles();
        if (files != null && files.length == 0) return null;

        for (File file : files) {
            if (file.isFile() && file.toString().endsWith(".class")) {
                ClassLoader ucl = new ClassLoader() {
                    @Override
                    protected Class<?> findClass(String name) {
                        byte[] buffer = new byte[0];
                        try {
                            buffer = Files.readAllBytes(Paths.get(name));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return defineClass(null, buffer, 0, buffer.length);
                    }
                };

                Class clazz = ucl.loadClass(file.getPath());

                if (Arrays.toString(clazz.getInterfaces()).contains("Animal")) {
                    try {
                        set.add((Animal) clazz.newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                    }
                }
            }
        }
        return set;
    }
}