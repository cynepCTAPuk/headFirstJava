package test;

public class FillArray {
    public static void random(int[] array) {
        //for(int i=0)
        for (int i = 0; i < array.length; i++) array[i] = (int) (Math.random() * 100);
    }//random(int[])
    public static void symbol(char[] array) {//char.length = 8195 or 2^13+3
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (i+33); //begin from 33
            if(i>93) array[i] = (char) (i+67);
        } //for(int i=0)
    }//random(int[])
} //test.FillArray class
