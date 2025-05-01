/*
Name: Edward Drobnis
Date: February 25, 2025
Title: Best Mark Overloaded
Description: Calculates the highest mark in a given array of 10 integers and in a given array of 10 doubles
*/

import java.util.Scanner;

class Main {
    // Method to calculate the highest mark in an integer array
    public static int calculateHighestMark(int[] marks) {
        // Stores the first number in the integer array in an integer, highestMark
        int highestMark = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highestMark) {
                highestMark = marks[i];
            }
        }
        return highestMark;
    };

    // Overloaded method to calculate the highest mark in a double array
    public static double calculateHighestMark(double[] marks) {
        // Stores the first number in the double array in a double, highestMark
        double highestMark = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highestMark) {
                highestMark = marks[i];
            }
        }
        return highestMark;
    }

    // Method to display the highest mark and all marks for an integer array
    public static void outputHighestMark(int[] marks) {
        // Initializes an integer, highestMark with the returned integer from the calculateHighestMark method
        int highestMark = calculateHighestMark(marks);
        System.out.printf("The highest mark out of %d students is: %d%% %n", marks.length, highestMark);
        System.out.printf("The marks of all %d students: %n", marks.length);
        // Prints each item in the marks array as an integer
        for (int mark : marks) {
            System.out.printf("%d%% %n", mark);
        }
    }

    // Method to display the highest mark and all marks for a double array
    public static void outputHighestMark(double[] marks) {
        // Initializes a double, highestMark with the returned double from the calculateHighestMark method
        double highestMark = calculateHighestMark(marks);
        System.out.printf("The highest mark out of %d students is: %.2f%% %n", marks.length, highestMark);
        System.out.printf("The marks of all %d students: %n", marks.length);
        // Prints each item in the marks array as a double
        for (double mark : marks) {
            System.out.printf("%.2f%% %n", mark);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Initializes an integer array to store 10 integer values
        int[] marks = new int[10];
        // Initializes a double array to store 10 double values
        double[] marksDouble = new double[10];

        for (int i = 0; i < marks.length; i++) {
            while (true) {
                System.out.printf("Enter the mark of student %d as an integer: ", i + 1);

                if (sc.hasNextInt()) {
                    // Reads the integer input which is set to a newly declared integer, input
                    int input = sc.nextInt();
                    if (input >= 0 && input <= 100) {
                        marks[i] = input;
                        break;
                    } else {
                        System.out.print("Input must be an integer between 0 and 100. ");
                    }
                } else {
                    System.out.print("Invalid input. Please enter an integer between 0 and 100. ");
                    sc.next();
                }
            }
        }
        outputHighestMark(marks);

        for (int i = 0; i < marksDouble.length; i++) {
            while (true) {
                System.out.printf("Enter the mark of student %d as a double: ", i + 1);

                if (sc.hasNextDouble()) {
                    // Reads the double input which is set to a newly declared double, input
                    double input = sc.nextDouble();
                    if (input >= 0 && input <= 100) {
                        marksDouble[i] = input;
                        break;
                    } else {
                        System.out.print("Input must be a double between 0 and 100. ");
                    }
                } else {
                    System.out.print("Invalid input. Please enter a double between 0 and 100. ");
                    sc.next();
                }
            }
        }
        outputHighestMark(marksDouble);
    }
}