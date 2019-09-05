/*
 * https://docs.microsoft.com/en-us/windows/win32/cimwin32prov/operating-system-classes
 * https://o7planning.org/en/10543/getting-hardware-information-in-java-application
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GeNetworkAdapterConfigurationInfo {

    public static void printComputerSystemProductInfo() {
        String vbClassName = "Win32_NetworkAdapterConfiguration";
        String vbScript = Utilities.makeVbScript(vbClassName);
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
            var list = new ArrayList<String>();
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                list.add(line);
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printComputerSystemProductInfo();
    }
}