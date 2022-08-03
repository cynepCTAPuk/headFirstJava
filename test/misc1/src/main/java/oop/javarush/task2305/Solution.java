package oop.javarush.task2305;

/*
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solution = {new Solution(), new Solution()};
        solution[0].innerClasses[0] = solution[0].new InnerClass();
        solution[0].innerClasses[1] = solution[0].new InnerClass();
        solution[1].innerClasses[0] = solution[1].new InnerClass();
        solution[1].innerClasses[1] = solution[1].new InnerClass();
        return solution;
    }

    public static void main(String[] args) {
//        Solution[] solution = getTwoSolutions();
//        System.out.println(solution[0].innerClasses[0]);
//        System.out.println(solution[0].innerClasses[1]);
//        System.out.println(solution[1].innerClasses[0]);
//        System.out.println(solution[1].innerClasses[1]);
    }
}
