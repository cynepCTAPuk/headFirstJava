package chap17;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddServerIntf extends Remote {
    String getMessage() throws RemoteException;
    long opsOfTwo(long one, long two) throws RemoteException;
}