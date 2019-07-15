class GetMiddle2 {
    public static String getMiddle(String word) {
        return word.length() > 2 ? getMiddle(word.substring(1, word.length() - 1)) : word;
    }
}