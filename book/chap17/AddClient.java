package chap17;

//import test.MyMath;
import java.rmi.Naming;

public class AddClient {
    public static void main(String args[]) throws Exception {
        AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup("//localhost/AddServer");
        System.out.println(addServerIntf.getMessage());
//        System.out.println(MyMath.insertSpaces(String.valueOf(addServerIntf.opsOfTwo(9_999_999, 9_999_999))));
        System.out.println(addServerIntf.opsOfTwo(9_999_999, 9_999_999));
    }
}