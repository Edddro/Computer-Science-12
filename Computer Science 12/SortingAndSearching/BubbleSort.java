// O(n^2) for all cases
class Main {
    public static void main(String[] args) {
        boolean loop;
        int[] array = {100, 34, 52, 75, 12, 3, 86, 24, 89, 44, 67};
        do {
            loop = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    loop = true;
                }
            }
        } while (loop);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}