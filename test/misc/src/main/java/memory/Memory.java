//https://stackoverflow.com/questions/31206851/how-much-memory-does-a-string-use-in-java-8
//Note: run it with -XX:-UseTLAB option
package memory;

public class Memory {
    public static void main(String[] args) {
        long m0 = Runtime.getRuntime().freeMemory();
        String s = new String("Alexandru Tanasescu");
        long m1 = Runtime.getRuntime().freeMemory();
        System.out.println(m0 - m1);
    }
}
