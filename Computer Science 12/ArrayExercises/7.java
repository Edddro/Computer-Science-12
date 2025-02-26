/*
Name: Edward Drobnis
Date: February 25, 2025
Title: Sum of Squares
Description: Calculates the sum of squares in an integer array
*/

class Main {
    // Main method to calculate sum of squares
    public static void main(String[] args) {
        // Initializes an integer array
        int[] ref = {1, 2, 3, 4, 5};

        // Initializes an integer, sumOfSquares, the store the sum of the squares
        int sumOfSquares = 0;

        for (int num : ref) {
            sumOfSquares += num * num;
        }

        System.out.println("The sum of the squares is: " + sumOfSquares);
    }
}