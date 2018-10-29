package test.Sorts;

public class TestSorting {
    public static void main(String[] args) {
        double t0, tBubble, tShake, tShakeClassic, tOddEven;
        int[] array = new int[10_000];
        NewArray.fillRandom(array);
        int[] arrayBubble, arrayShake, arrayShakeClassic, arrayOddEven;

        arrayBubble = array.clone();
        arrayOddEven = array.clone();
        arrayShakeClassic = array.clone();
        arrayShake = array.clone();

        t0 = System.nanoTime();
        Bubble.sort(arrayBubble);
        tBubble = System.nanoTime() - t0;

        t0 = System.nanoTime();
        OddEven.sort(arrayOddEven);
        tOddEven = System.nanoTime() - t0;

        t0 = System.nanoTime();
        ShakeClassic.sort(arrayShakeClassic);
        tShakeClassic = System.nanoTime() - t0;

        t0 = System.nanoTime();
        Shake.sort(arrayShake);
        tShake = System.nanoTime() - t0;
/*
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayBubble));
        System.out.println(Arrays.toString(arrayShake));
        System.out.println(Arrays.toString(arrayOddEven));
*/
        System.out.println();
        System.out.println("Bubble time nanoseconds \t" + String.format("%,.0f", tBubble));
        System.out.println("OddEven time nanoseconds\t" + String.format("%,.0f", tOddEven));
        System.out.println("ShakeC time nanoseconds \t" + String.format("%,.0f", tShakeClassic));
        System.out.println("Shake time nanoseconds  \t" + String.format("%,.0f", tShake));
    }
}
