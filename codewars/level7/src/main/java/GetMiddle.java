class GetMiddle {
    public static String getMiddle(String word) {
        int middle = word.length() / 2;
        if (word.length() % 2 == 0) return word.substring(middle - 1, middle + 1);
        else return word.substring(middle, middle + 1);
    }
}