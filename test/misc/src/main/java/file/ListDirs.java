package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListDirs {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        File path = new File(root);
        Stack<File> stack = new Stack<>();
        for (File file : path.listFiles()) {
            if (file.isFile()) list.add(file.getAbsolutePath());
            if (file.isDirectory()) stack.push(file);
        }
        while (!stack.empty()) {
            for (File file : stack.pop().listFiles()) {
                if (file.isFile()) list.add(file.getAbsolutePath());
                if (file.isDirectory()) stack.push(file);
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        List<String> list;
        list = getFileTree("c:/000");
        list.forEach(System.out::println);
    }
}
