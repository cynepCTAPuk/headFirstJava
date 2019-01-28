package chap16_arrays;
import java.util.*;
public class Exercise19 {
    int i;
    public Exercise19(int i) {this.i = i;}
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Exercise19 that = (Exercise19) obj;
        return i == that.i;
    }
//    public int hashCode() { return i; }

    public static void main(String[] args) {
        Exercise19[] ex1 = new Exercise19[2];
        Exercise19[] ex2 = new Exercise19[2];
        Arrays.fill(ex1, new Exercise19(1));
        System.out.println(Arrays.toString(ex1));
        Arrays.fill(ex2, new Exercise19(1));
        System.out.println(Arrays.toString(ex2));
        System.out.println(Arrays.equals(ex1, ex2));

    }
}
