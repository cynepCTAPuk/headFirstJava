public class FindEvenIndex2 {
    public static int findEvenIndex(int[] arr) {
        if (arr.length == 1) return 0;
        if (arr.length == 2) return -1;
        int idx = arr.length / 2;
        int counter = 0;
        while (true) {
            counter++;
            int sumL = 0;
            int sumR = 0;
            for (int i = 0; i < idx; i++) sumL += arr[i];
            for (int i = arr.length - 1; i > idx; i--) sumR += arr[i];

            System.out.println("Left " + sumL + " - "+ idx +" - " + sumR + " Right");

            if (sumL == sumR) return idx;

            if (sumL > sumR) idx--;
            else idx++;

            if (counter > arr.length / 2) return -1;
        }
    }
}