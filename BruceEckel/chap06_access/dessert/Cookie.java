package chap06_access.dessert;

//: access/dessert/Cookie.java
// Creates a library.
public class Cookie {
    public Cookie() {System.out.println("Cookie constructor");}
    protected void bite() { System.out.println("bite"); }
} ///:~