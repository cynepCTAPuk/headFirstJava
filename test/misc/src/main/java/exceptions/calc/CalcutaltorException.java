package exceptions.calc;

public class CalcutaltorException extends RuntimeException {
    public CalcutaltorException(String message) {
        super(message);
    }

    public CalcutaltorException(String message, Throwable cause) {
        super(message, cause);
    }
}
