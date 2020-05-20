void printFibonacci(long n){
    long a = 0;
    long b = 1;
    long c = 0;
    for (long i = 0; i < n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    System.out.print(a);
}




