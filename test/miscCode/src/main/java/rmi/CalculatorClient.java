package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(2732);
        Calculator calculator = (Calculator) registry.lookup(UNIQUE_BINDING_NAME);
        int a = 30;
        int b = 20;
        System.out.println(calculator.add(a, b));
        System.out.println(calculator.subtract(a, b));
        System.out.println(calculator.multiply(a, b));
        System.out.println(calculator.divide(100, b));
        System.out.println(calculator.pow(2, 10));
    }
}
