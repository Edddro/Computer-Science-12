/*
Name: Edward Drobnis
Date: February 25, 2025
Title: Square Root
Description: Declares a double array with 800 elements with calculates the square root of them
*/

class Main {
    // Main method to declare a double array and calculate its roots
    public static void main(String[] args) {
        // Declares a double array with 800 elements
        double[] sgt = new double[800];
        for (int i = 0; i < sgt.length; i++) {
            sgt[i] = Math.sqrt(i);
        }
    }
}