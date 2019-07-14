public class CountingDuplicates {
    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            String str1 = text.substring(i, i + 1);
            for (int j = i + 1; j < text.length(); j++) {
                String str2 = text.substring(j, j + 1);
                if (str2.equals(str1) && !str2.equals("*")) {
                    text = text.replaceAll(str2, "*");
                    counter++;
                }
            }
        }
        return counter;
    }
}