package test.Sorts;

public class Test {
    public static void main(String[] args) {
        double t0;
        int[] array = new int[10_000];
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
        System.out.println("Bubble\ttime nanoseconds\t" + String.format("%,.0f", tBubble));
        System.out.println("BubbleS\ttime nanoseconds\t" + String.format("%,.0f", tBubbleSort));
        System.out.println("OddEven\ttime nanoseconds\t" + String.format("%,.0f", tOddEven));
        System.out.println("ShakeCl\ttime nanoseconds\t" + String.format("%,.0f", tShakeClassic));
        System.out.println("Shake\ttime nanoseconds\t" + String.format("%,.0f", tShake));
    }
}
