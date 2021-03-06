package classLoader.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(
                Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath()
                        + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
//        System.out.println(packageName);
//        String packagePath = packageName.substring(1).replace('/', '\\');
        File directory = new File(packageName);

        for (File f : directory.listFiles()) {
            if (f.isFile() && f.toString().endsWith(".class")) {
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
                Class clazz = ucl.loadClass(f.getPath());
                hiddenClasses.add(clazz);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        try {
            for (Class<?> cl : hiddenClasses) {
                if (cl.getSimpleName().toLowerCase().contains(key.toLowerCase())) {
                    Constructor c = cl.getDeclaredConstructor();
                    c.setAccessible(true);
                    return (HiddenClass) c.newInstance();
/*
                    for (Constructor<?> constructor : cl.getDeclaredConstructors()) {
                        System.out.println(Arrays.toString(constructor.getParameterTypes()));
                        constructor.setAccessible(true);
                        System.out.println(cl.getSimpleName() + ":" + constructor);
                        return (HiddenClass) constructor.newInstance();
                    }
*/
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}

