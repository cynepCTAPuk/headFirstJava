package chap11_proxy.gumblemonitor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMonitorTestDriveOne {
    public static void main(String[] args)
            throws NotBoundException, MalformedURLException, RemoteException {
        String location = "rmi://localhost/gumballmachine";

        GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location);
        GumballMonitor monitor = new GumballMonitor(machine);
        System.out.println(monitor);
        monitor.report();
    }
}