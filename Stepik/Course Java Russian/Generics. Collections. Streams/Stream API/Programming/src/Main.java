public static IntStream pseudoRandomStream(int seed) {
    return IntStream.iterate(seed, n -> n * n / 10 % 1000);
}




