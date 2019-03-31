package beginning.listInterface;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        printCollection(list);
//        Collections.addAll(list, args); // for (String a : args) list.add(a);
//        Collections.shuffle(list, new Random());

        List<String> listAsList = Arrays.asList("Jython", "Groovy", "Scala", "JRuby", "Java", "Kotlin");
        printCollection(listAsList);
//        Collections.shuffle(listAsList);

        List<String> listBig = new ArrayList<>();
        listBig.addAll(list);
        listBig.addAll(listAsList);
        printCollection(listBig);
//        Collections.sort(listBig);
//        System.out.println(listBig.isEmpty() ? "'listBig is empty'" : listBig);

        listBig.stream()
                .filter(e -> e != "b" & e != "c" & e != "d")
                .forEach(e -> System.out.print(e + ", "));
        System.out.println("\tlistBig.stream()\n" + "                .filter(e -> e != \"b\" & e != \"c\" & e != \"d\")\n" + "                .forEach(e ->System.out.print(e + \", \"));");

        String joined = listBig.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
        System.out.println(joined + " \tString joined = listBig.stream()\n" + "                .map(Objects::toString)\n" + "                .collect(Collectors.joining(\", \"));");
        for (String str : listBig) System.out.print(str + ", ");
        System.out.println("\tfor (String str : listBig) System.out.print(str + \", \");");

        for (Iterator<?> it = listBig.iterator(); it.hasNext(); ) if (it.next() == "b") it.remove();
        System.out.println(listBig + "\t\tfor " + "(Iterator it = listBig.iterator(); it.hasNext(); )");
    }

    static void printCollection(Collection<?> c) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object e : c) sb.append(e.toString()).append(", ");
        if (sb.length() > 1) sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        System.out.println(sb + "\t" + c.getClass().getName());
    }
}