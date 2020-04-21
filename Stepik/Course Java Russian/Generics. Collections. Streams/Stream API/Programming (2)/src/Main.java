import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        String[] words = reader.readLine()
                .toLowerCase()
                .split("[^a-zA-Z0-9а-яА-Я]+");

        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(s -> {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        });

        map.entrySet().stream()
                .sorted((o1, o2) -> {
                    int i = o2.getValue() - o1.getValue();
                    return i == 0 ? o1.getKey().compareTo(o2.getKey()) : i;
                })
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
    }
}