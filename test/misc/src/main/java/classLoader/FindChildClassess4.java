package classLoader;

import io.github.classgraph.*;

import java.util.List;

public class FindChildClassess4 {
    public static void main(String[] args) {
        // Сканирует пакет javax.persistence и все его подпакеты
        String pkg = "io.github.classgraph";
        String routeAnnotation = pkg + ".Route";
        try (ScanResult scanResult =
                     new ClassGraph()
                             .verbose()                   // Log to stderr
                             .enableAllInfo()             // Scan classes, methods, fields, annotations
                             .whitelistPackages(pkg)      // Scan com.xyz and subpackages (omit to scan all packages)
                             .scan()) {                   // Start the scan
            for (ClassInfo routeClassInfo : scanResult.getClassesWithAnnotation(routeAnnotation)) {
                AnnotationInfo routeAnnotationInfo = routeClassInfo.getAnnotationInfo(routeAnnotation);
                List<AnnotationParameterValue> routeParamVals = routeAnnotationInfo.getParameterValues();
                // @com.xyz.Route has one required parameter
                String route = (String) routeParamVals.get(0).getValue();
                System.out.println(routeClassInfo.getName() + " is annotated with route " + route);
            }
        }
    }
}
