package oop.javarush.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
//        if (this.getClass() != obj.getClass()) return false;
        if (!(obj instanceof Solution)) return false;

        Solution solution = (Solution) obj;

        if (first != null) {
            if (!first.equals(solution.first))
                return false;
        } else {
            if (solution.first != null)
                return false;
        }

        if (last != null)
            return last.equals(solution.last);

        return solution.last == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
