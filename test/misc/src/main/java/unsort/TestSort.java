package unsort;

public class TestSort {
    public static void main(String[] args) {
        double t0;
        int[] array = new int[1_000];
        UtilsArray.fillRandom(array);

        Integer[] arrayBubbleSort = new Integer[array.length];
        int i = 0;
        for (int value : array) arrayBubbleSort[i++] = Integer.valueOf(value);

        int arrayBubble[] = array.clone();
        int arrayOddEven[] = array.clone();
        int arrayShakeClassic[] = array.clone();
        int arrayShake[] = array.clone();

        t0 = System.nanoTime();
        Bubble.sort(arrayBubble);
        double tBubble = System.nanoTime() - t0;

        t0 = System.nanoTime();
        BubbleObjectSort bubbleObjectSort = new BubbleObjectSort();
        bubbleObjectSort.sort(arrayBubbleSort);

        double tBubbleSort = System.nanoTime() - t0;

        t0 = System.nanoTime();
        OddEven.sort(arrayOddEven);
        double tOddEven = System.nanoTime() - t0;

        t0 = System.nanoTime();
        ShakeClassic.sort(arrayShakeClassic);
        double tShakeClassic = System.nanoTime() - t0;

        t0 = System.nanoTime();
        Shake.sort(arrayShake);
        double tShake = System.nanoTime() - t0;
/*
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayBubble));
        System.out.println(Arrays.toString(arrayShake));
        System.out.println(Arrays.toString(arrayOddEven));
*/
        System.out.println();
        System.out.println(String.format("unsort.Bubble\ttime nanoseconds\t%,.0f", tBubble));
        System.out.println(String.format("BubbleS\ttime nanoseconds\t%,.0f", tBubbleSort));
        System.out.println(String.format("unsort.OddEven\ttime nanoseconds\t%,.0f", tOddEven));
        System.out.println(String.format("ShakeCl\ttime nanoseconds\t%,.0f", tShakeClassic));
        System.out.println(String.format("unsort.Shake\ttime nanoseconds\t%,.0f", tShake));
    }
}
