package lafore.chap06.anagram;// anagram.java
// creates anagrams
// to run this program: C>java AnagramApp

import java.io.*;

////////////////////////////////////////////////////////////////
class AnagramApp {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    //-----------------------------------------------------------
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a word: ");    // get word
        String input = getString();
        size = input.length();                 // search its size
        count = 0;
        for (int j = 0; j < size; j++) arrChar[j] = input.charAt(j);   // put it in array
        doAnagram(size);                       // anagram it
    }  // end main()

    //-----------------------------------------------------------
    public static void doAnagram(int newSize) {
        int limit;
        if (newSize == 1) return;               // if too small, go no further

        for (int j = 0; j < newSize; j++) {     // for each position,
            doAnagram(newSize - 1);     // anagram remaining
            if (newSize == 2) displayWord();    // if innermost, display it
            rotate(newSize);                    // rotate word
        }
    }

    //-----------------------------------------------------------
    public static void rotate(int newSize) {    // rotate left all chars from position to end
        int i;
        int position = size - newSize;
        char temp = arrChar[position];                                      // save first letter
        for (i = position + 1; i < size; i++) arrChar[i - 1] = arrChar[i];  // shift others left
        arrChar[i - 1] = temp;                                              // put first on right
    }

    //-----------------------------------------------------------
    public static void displayWord() {
        if (count < 99) System.out.print(" ");
        if (count < 9) System.out.print(" ");
        System.out.print(++count + " ");

        for (int i = 0; i < size; i++) System.out.print(arrChar[i]);
        System.out.print("   ");
        System.out.flush();
        if (count % 6 == 0) System.out.println();
    }

    //-----------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}  // end class AnagramApp
////////////////////////////////////////////////////////////////
