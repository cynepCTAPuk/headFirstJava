/**
 * https://javarush.ru/tasks/com.javarush.task.task19.task1918#discussion
 */
package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParsingHmtlTag {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String file = console.readLine();
//        String file = "c:/000/1.txt";
        console.close();
        String tag = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(file));

        StringBuilder builder = new StringBuilder("");
        while (reader.ready()) builder.append(reader.readLine());
        reader.close();

        List<Integer> startList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();

        int startIdx = 0;
        int endIdx = 0;
        int count = 0;
        boolean swap = false;
        while (true) {
            startIdx = builder.indexOf("<" + tag, startIdx);
            if (startIdx == -1) break;
            else startList.add(startIdx++);

            if (startIdx < endIdx) swap = true;

            endIdx = builder.indexOf("</" + tag + ">", endIdx);
            if (endIdx == -1) break;
            else {
                endList.add(endIdx++);
                if (swap) {
                    int last = endList.size() - 1;
                    int temp = endList.get(last);
                    endList.set(last, endList.get(last - 1));
                    endList.set(last - 1, temp);
                    swap = false;
                }
            }
        }
//        System.out.println(builder);
        for (int i = 0; i < startList.size(); i++)
            System.out.println(builder.substring(startList.get(i), endList.get(i) + tag.length() + 3));
    }
}

