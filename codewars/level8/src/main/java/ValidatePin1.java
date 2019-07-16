public class ValidatePin1 {
    public static boolean validatePin(String pin) {
        int pinLenght = pin.length();
        if (pinLenght == 4 | pinLenght == 6) {
            char[] chars = pin.toCharArray();
            for (char ch : chars) {
                if ((int) ch < 48) return false;
                if ((int) ch > 57) return false;
            }
            return true;
        } else return false;

    }
}