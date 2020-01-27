package collections.task3611_1;

import java.util.Set;
import java.util.TreeSet;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humanRelationships;
    static Set<Integer> result = new TreeSet<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humanRelationships = generateRelationships();
/*
        for (int i = 0; i < solution.humanRelationships.length; i++) {
            for (int j = 0; j < solution.humanRelationships[i].length; j++) {
                System.out.printf("%-7s", solution.humanRelationships[i][j]);
            }
            System.out.println();
        }
*/
        Set<Integer> allFriendsAndPotentialFriends =
                solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);  // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends =
                solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);               // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        while (deep > 0) {
            deep--;
            for (int i = 0; i < humanRelationships.length; i++) {
                if ((index < humanRelationships.length) &&
                        humanRelationships[Math.max(i, index)][Math.min(i, index)]) {
                    result.add(i);
                    getAllFriendsAndPotentialFriends(i, deep);
                }
            }
            result.remove(index);
        }
        return result;
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i])
                set.remove(i);
            else if ((i > index) && humanRelationships[i][index])
                set.remove(i);
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}