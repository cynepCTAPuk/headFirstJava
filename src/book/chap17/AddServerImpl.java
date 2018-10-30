package book.chap17;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {
    public static final String MESSAGE = "Hello Big World";

    public AddServerImpl() throws RemoteException {
        super(0);    // required to avoid the 'rmic' step, see below
    }

    public String getMessage() {
        return MESSAGE;
    }

    public long opsOfTwo(long one, long two) {
        return one * two;
    }
}