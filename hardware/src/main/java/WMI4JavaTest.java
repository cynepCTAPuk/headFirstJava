/*
 * https://github.com/profesorfalken/WMI4Java
 */

import com.profesorfalken.wmi4java.WMI4Java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WMI4JavaTest {
    public static void main(String[] args) {
//        List<String> wmiClassesList = WMI4Java.get().listClasses();
//        List<String> wmiClassesList = WMI4Java.get().namespace("root/cimv2").listClasses();
//        wmiClassesList.stream().sorted().forEach((a) -> System.out.println(a));

//        Map<String, String> wmiObject = WMI4Java.get().getWMIObject("Win32_BIOS");
//        Map<String, String> wmiObject = WMI4Java.get().getWMIObject("Win32_PRINTER");
//        System.out.println(WMI4Java.get().getRawWMIObjectOutput("Win32_BIOS"));
        //Example get processes named java.exe BUT doesn't work
//        Map<String, String> wmiObject = WMI4Java.get().filters(Arrays.asList("$_.Name -eq \"java.exe\"")).getWMIObject("Win32_Process");
        //Example get only specific properties from system processes BUT doesn't work
        Map<String, String> wmiObject = WMI4Java.get().properties(Arrays.asList("Name", "CommandLine", "ProcessId")).getWMIObject("Win32_Process");

        int n = 0;
        for (String key : wmiObject.keySet()) if (n < key.length()) n = key.length();
        String format = "%-" + n + "s";
        wmiObject.forEach((key, value) -> System.out.printf(format + ": %s\n", key, value));
    }
}
