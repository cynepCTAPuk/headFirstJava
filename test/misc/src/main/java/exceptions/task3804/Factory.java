package exceptions.task3804;

public class Factory {
    public static Throwable createException(Enum en) {
        if (en == null) return new IllegalArgumentException();

        String message = en.name().charAt(0) +
                en.name().substring(1).toLowerCase().replace('_', ' ');
        switch (en.getClass().getSimpleName()) {
            case "ApplicationExceptionMessage":
                return new Exception(message);
            case "DatabaseExceptionMessage":
                return new RuntimeException(message);
            case "UserExceptionMessage":
                return new Error(message);
            default:
                return new IllegalArgumentException();
        }
    }
}