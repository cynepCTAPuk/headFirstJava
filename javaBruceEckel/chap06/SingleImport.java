package chap06;

//: access/SingleImport.java
import java.util.ArrayList;
public class SingleImport {
    public static void main(String[] args) {
        ArrayList list = new java.util.ArrayList();
        System.out.println(list.isEmpty());
    }
} ///:~