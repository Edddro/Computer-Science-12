/*
Name: Edward Drobnis
Date: February 25, 2025
Title: First Negative Value
Description: Loops through an integer array until a negative integer is found
*/

class Main {
    // Main method to locate a negative number
    public static void main(String[] args) {
        int[] pg = {1, -2, 3, 5};
        int indx = pg.length;
        for (int i = 0; i < pg.length; i++) {
            if (pg[i] < 0) {
                indx = i;
                break;
            }
        }
        System.out.println("The index of the first negative number is: " + indx);
    }
}