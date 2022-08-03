package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Reverse extends Remote {
    String reverse(String str) throws RemoteException;
    String upperCase(String str) throws RemoteException;
}
