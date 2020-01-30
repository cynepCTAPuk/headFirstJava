package classLoader;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

public class FindChildClassess3 {
    public static void main(String[] args) {
        // Сканирует пакет javax.persistence и все его подпакеты
//        String pkg = "io.github.classgraph";
        String pkg = "java.util";
        try (ScanResult scanResult =
                     new ClassGraph()
                             .enableAllInfo()
                             .whitelistPackages(pkg)
                             .scan()) {
            for (ClassInfo classInfo : scanResult.getAllClasses()) {
                System.out.println(classInfo.getName());
            }
        }
    }
}
