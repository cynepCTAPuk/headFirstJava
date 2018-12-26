package chap02;

import java.nio.file.*;
import java.util.*;

public class ShowProperties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println("-".repeat(66));
        System.out.println(System.getProperty("user.name"));
        System.out.println("-".repeat(66));
        System.out.println(System.getProperty("java.library.path"));
    }
}
