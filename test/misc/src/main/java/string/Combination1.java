package string;

class Combination1 {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e"};
        int r = 2;
        printCombination(arr, r);
    }

    static void printCombination(String[] arr, int r) {
        int n = arr.length;
        String[] data = new String[r];
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }

    static void combinationUtil(String[] arr, String[] data, int start, int end, int index, int r) {
        if (index == r) {
            for (int j = 0; j < r; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println("");
            return;
        }
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }
}