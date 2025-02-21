import java.util.Random;

class Main {
    public static int[] highestNumber(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > numbers[max]) {
                    max = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[max];
            numbers[max] = temp;
        }
        return numbers;
    }

    public static void printArray(int highest, int[] numbers, float[] newNumbers) {
        System.out.println("the highest number is: " + highest);
        System.out.println("Original Array: ");
        for (float number : numbers) {
            System.out.printf("%.6f %n", number);
        }
        System.out.println("New Array: ");
        for (float number : newNumbers) {
            System.out.printf("%.6f %n", number);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100) + 1;
        }

        int highest = highestNumber(numbers)[0];

        float[] newNumbers = new float[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i] / (float)highest;
        }

        printArray(highest, numbers, newNumbers);
    }
}