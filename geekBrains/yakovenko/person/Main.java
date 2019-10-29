package person;

import java.util.*;

public class Main {
    public static void main(String[] args) {
/*
        ArrayList<person> persons = new ArrayList<person>();

        person john = new person.TaxPayer();
        john.name = "John";
        john.age = 20;
        john.sex = true;
        persons.add(john);

        person jan = new person();
        jan.name = "Jan";
        jan.age = 40;
        jan.sex = true;
        persons.add(jan);

        person mary = new person();
        mary.name = "Mary";
        mary.age = 17;
        mary.sex = false;
        persons.add(mary);

        Collections.sort(persons);
        System.out.println(persons.toString());
*/
/*
        int a = 10;
        int f = tasks.Factorial.factorial(a);
        System.out.println("tasks.Factorial " + a + "! = " + f);
*/
//        for (int i : new int[]{1, 2, 3}) System.out.print(i+"\t");

        String phrase = "Во саду ли в огороде...";
        phrase = phrase.toLowerCase();
        System.out.println("\"Sentence\"\t"+phrase+" \"Кол-во символов\" = " + phrase.length()+"\n");

        Map<Character, Integer> countTree = new TreeMap<Character, Integer>();
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (!countTree.containsKey(c)) {
                countTree.put(c, 1);
            } else {
                int cnt = countTree.get(c);
                countTree.put(c, cnt + 1);
            }
        }
        System.out.println("\"countTree\"\t" + countTree);

/*
        System.out.print("\"loop for countTree\"\t");
        for (Character i : countTree.keySet()) {
            for (int n = 0; n < countTree.get(i); n++) {
            }
            System.out.print(i);
        }
*/
        System.out.print("\n"+"\"countHash\"\t");
        Map<Character, Integer> countHash = new HashMap<Character, Integer>();
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (!countHash.containsKey(c)) {
                countHash.put(c, 1);
            } else {
                int oldCnt = countHash.get(c);
                countHash.put(c, oldCnt + 1);
            }
        }
        System.out.println(countHash);

/*
        System.out.print("\"loop for countHash\"\t");
        for (Character i : countHash.keySet()) {
            System.out.print(i);
        }
*/
/*
        ArrayList<Integer> arr = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int q = scanner.nextInt();
            arr.add(q);
            System.out.println(arr);
*/
    } //main(String[])
} // person.io.FileTest class