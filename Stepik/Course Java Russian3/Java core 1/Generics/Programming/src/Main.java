Box<Integer> boxingValue(double value) {
    // enter your code
}


class Box<T> {
    private final T value;

    Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}