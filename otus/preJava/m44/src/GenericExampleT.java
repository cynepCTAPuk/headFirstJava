
public class GenericExampleT<T> {
    private T value;

    private GenericExampleT(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        GenericExampleT<Integer> integerGenericExample =
                new GenericExampleT<>(1);
        Integer valueInteger = integerGenericExample.getValue();

        GenericExampleT<String> stringGenericExample =
                new GenericExampleT<>("word");
        String valueString = stringGenericExample.getValue();

        System.out.println(valueInteger);
        System.out.println(valueString);
    }
}