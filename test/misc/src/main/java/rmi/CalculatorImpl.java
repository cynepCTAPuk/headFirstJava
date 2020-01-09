package rmi;

import java.rmi.RemoteException;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    @Override
    public int subtract(int x, int y) throws RemoteException {
        return x - y;
    }

    @Override
    public int multiply(int x, int y) throws RemoteException {
        return x * y;
    }

    @Override
    public int divide(int x, int y) throws RemoteException {
        return x / y;
    }

    @Override
    public int pow(int x, int y) throws RemoteException {
        return (int) Math.pow(x, y);
    }
}
