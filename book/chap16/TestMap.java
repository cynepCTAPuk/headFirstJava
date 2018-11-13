package chap16;

import java.util.HashMap;

class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Kathy", 42);
        scores.put("Bert", 343);
        scores.put("Skyler", 420);

        System.out.println(scores + "\n");

        System.out.println("scores.containsKey(\"Bert\") \t- " + scores.containsKey("Bert"));
        System.out.println("scores.containsValue(42) \t- " + scores.containsValue(42));
        System.out.println("scores.get(\"Bert\") \t\t\t- " + scores.get("Bert"));
        System.out.println("scores.keySet() \t\t\t- " + scores.keySet());
        System.out.println("scores.entrySet() \t\t\t- " + scores.entrySet());

        scores.remove("Skyler");
        System.out.println("\n" + scores);
    }
}
