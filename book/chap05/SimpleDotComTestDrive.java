package chap05;

public class SimpleDotComTestDrive {

    public static void main(String[] args) {
        int numOfGuesses = 0;
        chap05.GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5) + 1;
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        theDotCom.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive) {
            String guess = helper.getUserInput("Enter a number [1-7]");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " +numOfGuesses+" guesses");
            }//end if
        }//end while
    }//end main
}//end class
