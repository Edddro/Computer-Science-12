/*
Name: Edward Drobnis
Date: February 25, 2025
Title: Age Span
Description: Determines the highest and lowest age in a randomly generated array
*/

class Main {
    // Method to find the maximum value in the array using linear search
    public static int max(int[] ages) {
        // Initialize max with the first element in the integer array
        int max = ages[0];

        for (int age : ages) {
            if (age > max) {
                max = age;
            }
        }
        return max;
    }

    // Method to find the minimum value in the integer array using linear search
    public static int min(int[] ages) {
        // Initialize min with the first element in the integer array
        int min = ages[0];

        for (int age : ages) {
            if (age < min) {
                min = age;
            }
        }
        return min;
    }

    // Method to compute the difference between max and min values
    public static int difference(int max, int min) {
        return max - min;
    }

    // Main method to generate ages and print the difference between the oldest and youngest
    public static void main(String[] args) {
        // Array to store 50 randomly generated ages
        int[] ages = new int[50];

        // Loop to change the values in the ages array with random values between 1 and 100
        for (int i = 0; i < ages.length; i++) {
            ages[i] = (int) (Math.random() * 100) + 1;
        }

        System.out.printf("The oldest age is %d years old.\n", max(ages));
        System.out.printf("The minimum age is %d years old.\n", min(ages));
        System.out.printf("The difference between %d and %d is %d years", max(ages), min(ages), difference(max(ages), min(ages)));
    }
}