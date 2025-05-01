// O(n^2) for all cases
class Main {
    public static void main(String[] args) {
        int[] array = {100, 34, 52, 75, 12, 3, 86, 24, 89, 44, 67};
        int min, minIndex;
        for(int i = 0; i < array.length; ++i) {
            min = array[i];
            minIndex = i;
            for(int j = i + 1; j < array.length; ++j) {
                if(array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            array[minIndex] = array[i];
            array[i] = min;
        }

        for(int num : array) {
            System.out.print(num + " ");
        }
    }
}