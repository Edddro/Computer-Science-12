/*
Name: Edward Drobnis
Date: February 25, 2025
Title: Best Mark
Description: Calculates the highest mark in a given array of 10 integers
*/

import java.util.Scanner;

// Finds the highest mark in a given array of integers
class Main {

    public static int calculateHighestMark(int[] marks) {
        // Initialize highestMark as an integer with the first element in the array.
        int highestMark = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highestMark) {
                highestMark = marks[i];
            }
        }
        return highestMark;
    }

    // Collects user input, stores student marks in an array, and finds the highest mark.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declare an array of 10 integers to store student marks
        int[] marks = new int[10];
        for (int i = 0; i < marks.length; i++) {
            while (true) {
                System.out.printf("Enter the mark of student %d: ", i + 1);

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

        System.out.printf("The highest mark out of %d students is: %d%% %n", marks.length, calculateHighestMark(marks));
        System.out.printf("The marks of all %d students: %n", marks.length);
        for (int mark : marks) {
            System.out.printf("%d%% %n", mark);
        }
        sc.close();
    }
}