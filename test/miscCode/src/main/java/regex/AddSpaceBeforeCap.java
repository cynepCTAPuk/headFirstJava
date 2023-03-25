package regex;

public class AddSpaceBeforeCap {
    public static void main(String[] args) {
        String origin = "ЭтоОченьДлинныйТекстВообщеБезПробелов ИТутБылПробел AbCd";
        String result = origin.replaceAll("(?<=\\S)(?=[А-ЯЁA-Z])", " ");
        System.out.println(result);
    }
}
