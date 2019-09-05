/*
 * https://docs.microsoft.com/en-us/windows/win32/cimwin32prov/operating-system-classes
 * https://o7planning.org/en/10543/getting-hardware-information-in-java-application
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GetHardwareInfo {

    public static void printComputerSystemProductInfo() {

//        String vbClassName = "Win32_Account";
//        String[] propNames = new String[]{"Caption", "Description", "Domain", "InstallDate", "LocalAccount", "Name", "SID", "SIDType", "Status"};
//        String vbClassName = "Win32_BootConfiguration";
//        String[] propNames = new String[]{"Caption", "Description", "SettingID", "BootDirectory", "ConfigurationPath", "LastDrive", "Name", "ScratchDirectory", "TempDirectory"};
        String vbClassName = "Win32_ComputerSystemProduct";
        String[] propNames = new String[]{"Caption", "Description", "IdentifyingNumber", "Name", "SKUNumber", "UUID", "Vendor", "Version"};

        String vbScript = MyUtility.makeVbScript(vbClassName, propNames);

        System.out.println("----------------------------------------");
        System.out.println(vbScript);
        System.out.println("----------------------------------------");

        try {
            // Create temporary file.
            File file = File.createTempFile("vbsfile", ".vbs");
            System.out.println("Create File: " + file.getAbsolutePath());
            System.out.println("------");

            // Write script content to file.
            FileWriter fw = new FileWriter(file);
            fw.write(vbScript);
            fw.close();

            // Execute the file.
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            // Create Input stream to read data returned after execute vb script file.
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            Map<String, String> map = new HashMap<String, String>();
            Map<String, String> map = new TreeMap<String, String>();
            String line;
            int i = 0;
            while ((line = input.readLine()) != null) {
                if (i >= propNames.length) break;
                String key = propNames[i];
                map.put(key, line);
                i++;
            }
            input.close();

//            for (String propName : propNames) System.out.println(propName + " : " + map.get(propName));
            map.forEach((k, v) -> System.out.println(k + " : " + v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printComputerSystemProductInfo();
    }
}