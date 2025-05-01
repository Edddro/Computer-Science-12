// Best O(n) - Worst O(n^2) -Average O(n^2)
class Main {
    public static void main(String[] args) {
        int[] array = {100, 34, 52, 75, 12, 3, 86, 24, 89, 44, 67};
        int itemToInsert, i;
        boolean keepGoing;
        for (int j = 1; j < array.length; j++) {
            itemToInsert = array[j];
            i = j - 1;
            keepGoing = true;
            while (i >= 0 && keepGoing) {
                if(itemToInsert < array[i]) {
                    array[i + 1] = array[i];
                    i--;
                    if(i == -1) {
                        array[0] = itemToInsert;
                    }
                } else {
                    keepGoing = false;
                    array[i + 1] = itemToInsert;
                }
            }
        }
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}