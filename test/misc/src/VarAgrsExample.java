package src;

class VarArgsExample {
    int sumArrays(int[]... intArrays) {
        int sum, i, j;
        sum = 0;
        for (i = 0; i < intArrays.length; i++) {
            for (j = 0; j < intArrays[i].length; j++) {
                sum += intArrays[i][j];
            }
        }
        System.out.println(intArrays.length);
        return (sum);
    }

    public static void main(String args[]) {
        VarArgsExample va = new VarArgsExample();
        int sum = 0;
        int a[] = new int[]{1, 2, 3, 4, 5};
        int b[] = new int[]{1, 2, 3, 4, 5};
        int c[] = new int[]{1, 2, 3, 4, 5};
        int d[] = new int[]{1, 2, 3, 4, 5};
        int e[] = new int[]{1, 2, 3, 4, 5};
        sum = va.sumArrays(a, b, c, d, e);
/*
        sum = va.sumArrays(
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 8, 9},
                new int[]{10, 11, 12});
*/
        System.out.println("The sum of the numbers is: " + sum);
    }
}