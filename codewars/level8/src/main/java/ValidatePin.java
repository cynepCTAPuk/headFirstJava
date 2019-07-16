public class ValidatePin {
    public static boolean validatePin(String pin) {
        return (pin.length() == 4 || pin.length() == 6)
                && pin.replaceAll("[0-9]","").length() == 0;
    }
}