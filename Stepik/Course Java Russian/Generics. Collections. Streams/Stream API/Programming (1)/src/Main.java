public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {

    List<T> list = stream.collect(Collectors.toList());
    if (list.isEmpty()) {
        minMaxConsumer.accept(null,null);
        return;
    }
    Optional<T> min = list.stream().min(order);
    Optional<T> max = list.stream().max(order);
    T a = min.get();
    T b = max.get();
    minMaxConsumer.accept(a, b);
}