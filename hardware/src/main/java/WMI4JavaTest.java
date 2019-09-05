/*
 * https://github.com/profesorfalken/WMI4Java
 */

import com.profesorfalken.wmi4java.WMI4Java;

import java.util.List;
import java.util.Map;

public class WMI4JavaTest {
    public static void main(String[] args) {
//        List<String> wmiClassesList = WMI4Java.get().listClasses(); // Error
//        List<String> wmiClassesList = WMI4Java.get().namespace("root/WMI").listClasses(); // nothing
        //Example win32_BIOS
//        Map<String, String> win32_bios = WMI4Java.get().getWMIObject("Win32_BIOS");
//        win32_bios.forEach((a, b) -> System.out.println(a + " : " + b));
        //Example Win32_PRINTER
        Map<String, String> win32_printer = WMI4Java.get().getWMIObject("Win32_PRINTER");
        win32_printer.forEach((a, b) -> System.out.println(a + " : " + b));
    }
}
