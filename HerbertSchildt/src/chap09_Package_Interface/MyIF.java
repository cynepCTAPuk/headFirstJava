package chap09_Package_Interface;

public interface MyIF {
    // This is a "norma" interface method declaration. It does NOT define a default implementation.
    int getNumber();

    // This is a default method. Notice that it provides a default implementation.
    default String getString() {
        return "Default String";
    }
}
