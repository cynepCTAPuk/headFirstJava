import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int i = 1;
        while (sum < n) {
            list.add(i);
            sum += i;
            i++;
        }
//        System.out.println(list);
        if (sum > n) {
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(n - sum);
        }
        System.out.println(list.size());
        list.forEach(x -> System.out.print(x + " "));
    }
}