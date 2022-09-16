package classLoader;

import org.reflections.Reflections;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class FindChildClassess2 {
    public static void main(String[] args) {
        String packageName = FindChildClassess2.class.getPackageName();
        Set set = loadClasses(packageName);
        System.out.println(set);
    }

    public static Set<Class<?>> loadClasses(String packageName) {
        Set<Class<?>> classes = new HashSet<>();
        URL resource = Thread.currentThread().getContextClassLoader()
                .getResource(packageName.replace('.', '/'));

        File directory = new File(resource.getFile());
        if (!directory.exists()) return classes;
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) return classes;
        for (File file : files) {
            //в другие пакеты уходить ненужно
            if (file.isFile() && file.getName().endsWith(".class")) {
                try {
                    classes.add(Class.forName(String.format("%s.%s", packageName,
                            file.getName().substring(0, file.getName().indexOf(".")))));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return classes;
    }

    public static boolean checkAllParents(Class<?> type, Class<?> hasParentType) {
        Class<?> parent = type.getSuperclass();
        if (parent == Object.class) return false;
        if (parent.getClass() == hasParentType.getClass()) return true;
        return checkAllParents(parent, hasParentType);
    }
}
