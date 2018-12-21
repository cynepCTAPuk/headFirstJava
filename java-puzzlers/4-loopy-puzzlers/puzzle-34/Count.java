public class Count {
    public static void main(String[] args) {
        final int START = 2_000_000_000;
        int count = 0;
        for (float f = START; f < START + 50; f++)
            count++;
        System.out.println(count);
    }
}
