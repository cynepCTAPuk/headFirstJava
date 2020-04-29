import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Dot> dotList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dotList.add(new Dot(scanner.nextInt(), -1, -1));
            dotList.add(new Dot(scanner.nextInt(), 1, -1));
        }
        for (int i = 0; i < m; i++) {
            dotList.add(new Dot(scanner.nextInt(), 0, i));
        }
        dotList.sort((o1, o2) -> {
            int i = o1.x - o2.x;
            if (i == 0) return o1.type - o2.type;
            return i;
        });
        int count = 0;
        int[] dots = new int[m];
        for (Dot d : dotList) {
            if(d.type==-1) count++;
            else if(d.type==1) count--;
            else if(d.type==0) dots[d.order] = count;
        }
        for(int i: dots) System.out.print(i + " ");
    }

    private static class Dot {
        int x;
        int type;
        int order;

        public Dot(int x, int type, int order) {
            this.x = x;
            this.type = type;
            this.order = order;
        }
    }
}
