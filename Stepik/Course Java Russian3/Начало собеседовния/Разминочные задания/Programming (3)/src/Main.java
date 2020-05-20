void calculateAndPrint(int n) {
    if (n > 1000 && n < 10_000) {
        if (n / 100 % 2 == 0) System.out.println(n + 100);
        else System.out.println(n * 2);
    }
}