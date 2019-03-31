package beginning.generic;

public class GenericExampleType<T> {
    private T value;

    public GenericExampleType(T value) {
        this.value = value;
    }

    public T getT() {
        return value;
    }

    public static void main(String[] args) {
        GenericExampleType<Integer> intObject = new GenericExampleType<>(1);
        Integer valueInteger = intObject.getT();
        GenericExampleType<Double> doubleObject = new GenericExampleType<>(1.);
        Double valueLong = doubleObject.getT();
        GenericExampleType<String> stringObject = new GenericExampleType<>("word");
        String valueString = stringObject.getT();

        System.out.println(valueInteger);
        System.out.println(valueLong);
        System.out.println(valueString);
    }
}
