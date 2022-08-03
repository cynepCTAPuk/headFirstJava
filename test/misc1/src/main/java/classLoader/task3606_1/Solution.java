package classLoader.task3606_1;

import java.io.File;
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
        String packagePath = packageName.substring(1).replace('/', '\\');
        File directory = new File(packagePath);
        String pathHiddenFiles =
                "com/javarush/task/task36/task3606/data/second".replace('/', '.');

        if (directory.isDirectory()) {
            for (File f : directory.listFiles()) {
                if (f.toString().endsWith(".class")) {
                    String nameClass = pathHiddenFiles + '.' + f.getName();
                    Class<?> clazz = Class.forName(nameClass.substring(0, nameClass.length() - 6));
                    hiddenClasses.add(clazz);
                }
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        try {
            int i = 0;
            for (Class<?> cl : hiddenClasses) {
                if (cl.getSimpleName().toLowerCase().contains(key)) {
                    return (HiddenClass) cl.newInstance();
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
        }
        return null;
    }
}

