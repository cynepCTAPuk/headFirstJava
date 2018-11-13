package chap05;

import java.util.Arrays;

public class SimpleDotCom {

    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
        return;
    }//end setLocationCells()

    public String checkYourself(String stringGuess) {
        int guess;
        String result;

        guess = Integer.parseInt(stringGuess);
        result = "miss";

        for (int i = 0; i < locationCells.length; i++) {
            if (locationCells[i] == guess) {
                locationCells[i] = -1;
                result = "hit";
                numOfHits++;
                System.out.println(Arrays.toString(locationCells));
                break;
            }
        }//end for
        if (numOfHits == locationCells.length) {
            result = "kill";
        }//end if

        System.out.println(result);
        return result;
    }//end checkYourself()
}//end class
