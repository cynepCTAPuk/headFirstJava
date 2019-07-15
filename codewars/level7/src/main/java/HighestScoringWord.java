public class HighestScoringWord {
    public static String high(String s) {
        String winner = "";
        int highScore = 0;

        for (String word : s.split(" ")) {
            int score = 0;
            for (char c : word.toCharArray()) score += c - 'a' + 1;
            if (score > highScore) {
                winner = word;
                highScore = score;
            }
        }
        return winner;
    }
}