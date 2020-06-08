void checkSortArrayLength(int[] a){
    int size = a.length;
    int[] d = new int[size];
    for (int i = 0; i < size; i++) {
        d[i] = 1;
        for (int j = 0; j < i; j++)
            if (a[i] > a[j])
                d[i] = Math.max(d[j] + 1, d[i]);
    }
    int max = 0;
    for (int i : d) if (max < i) max = i;
    System.out.println(max);
}