package classLoader;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FindChildClassess {
    public static void main(String[] args) {

    }

    static Set<Class<?>> find(String package1) {
        Reflections reflections = new Reflections(package1, new SubTypesScanner());
        Set<Class<?>> subTypes = new TreeSet<>();
/*
        String[] classes = reflections.getStore().get(SubTypesScanner.class.getSimpleName()).values();
        for (String className : classes) {
            try {
                Class subType = Class.forName(className);
                if (SuperClass.class.isAssignableFrom(subType)) {
                    subTypes.add(subType);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Этого не может быть:)", e);
            }
        }
*/
        return subTypes;
    }
}
