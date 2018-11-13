package chap17;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class AddServer {

    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");

        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            System.out.println("java RMI registry already exists.");
        }

        try {
            AddServerImpl addServerImpl = new AddServerImpl();
            Naming.rebind("AddServer", addServerImpl);
            System.out.println("PeerServer bound in registry");
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }
}