import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class OperatingSystemMXBeanTest {
    public static void main(String[] args) {
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(os.getArch());
        System.out.println(os.getAvailableProcessors());
        System.out.println(os.getName());
        System.out.println(os.getSystemLoadAverage());
        System.out.println(os.getVersion());
        System.out.println(os.getObjectName());
/*
        try {
            ManagementObjectSearcher searcher = new ManagementObjectSearcher(
                    "root\\CIMV2",
                    "SELECT * FROM Win32_NetworkAdapterConfiguration");
            for (ManagementObject queryObj : searcher.Get()) {
                System.out.println("-----------------------------------");
                System.out.println("Win32_NetworkAdapterConfiguration instance");
                System.out.println("-----------------------------------");
                if (queryObj["IPAddress"] == null)
                    System.out.println("IPAddress: {0}", queryObj["IPAddress"]);
                else {
                    String[] arrIPAddress = (String[]) (queryObj["IPAddress"]);
                    for (String arrValue : arrIPAddress) System.out.println("IPAddress: " + arrValue);
                }
            }
        } catch (ManagementException e) {
            MessageBox.Show("An error occurred while querying for WMI data: " + e.Message);
        }
*/
    }
}
