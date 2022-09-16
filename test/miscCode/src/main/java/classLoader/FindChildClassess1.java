package classLoader;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class FindChildClassess1 {
    public static void main(String[] args) {
        Reflections reflections = (Reflections) new Reflections("java.util").getSubTypesOf(Queue.class);
        System.out.println(reflections);
    }

}
