/*
Author: Edward Drobnis
Date: March 2, 2025
Title: Matrix
Description: Multiplies two matrices
*/

import java.util.Scanner;

// Main class to print the multiplied matrix, given two matrices
public class Matrix {
    // Method, matrixMultiply, to multiply two matrices, given two matrices, number of rows, and number of columns in both matrix
    public static void matrixMultiply(int[][] firstMatrix, int[][] secondMatrix, int rowsFirstMatrix, int columnsFirstMatrix, int columnsSecondMatrix) {
        // 2D integer array, resultMatrix, with the size of the number of rows in the first matrix by the number of columns in the second matrix
        int[][] resultMatrix = new int[rowsFirstMatrix][columnsSecondMatrix];

        for (int i = 0; i < rowsFirstMatrix; i++) {
            for (int j = 0; j < columnsSecondMatrix; j++) {
                for (int k = 0; k < columnsFirstMatrix; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        System.out.println("Resultant Matrix (First Matrix x Second Matrix):");
        // Calls the printMatrix method, passing an array, resultMatrix, and a String, "Result Matrix"
        printMatrix(resultMatrix, "Result Matrix");
    }

    // Method, validateInteger, to return an integer of the valid input (input is a positive integer or -1)
    public static int validateInteger(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                // Declares an integer, value, as the valid input
                int value = input.nextInt();
                if (value > 0 || value == -1) {
                    return value;
                } else {
                    System.out.println("Value must be a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                input.next();
            }
        }
    }

    // Method, fillMatrix, to update the values of both matrices, given the matrix (as a 2D integer array) and matrixName
    public static void fillMatrix(Scanner input, int[][] matrix, String matrixName) {
        System.out.println("Enter values for " + matrixName + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                while (true) {
                    System.out.printf("Enter integer value for row %d, column %d: ", i + 1, j + 1);
                    if (input.hasNextInt()) {
                        matrix[i][j] = input.nextInt();
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter an integer.");
                        input.next();
                    }
                }
            }
        }
    }

    // Method, printMatrix, to print the given 2D integer matrix and matrixName
    public static void printMatrix(int[][] matrix, String matrixName) {
        System.out.println(matrixName + ":");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    // Main method to call the appropiate methods to calculate the result of the multiplied matrices
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            while (true) {
                // Declares an integer, rowsFirstMatrix, as the given valid input
                int rowsFirstMatrix = validateInteger(input, "Enter the number of rows for the first matrix (or -1 to quit): ");
                if (rowsFirstMatrix == -1) {
                    System.out.println("Exiting program...");
                    break;
                }
                // Declares an integer, columnsFirstMatrix, as the given valid input
                int columnsFirstMatrix = validateInteger(input, "Enter the number of columns for the first matrix (rows for the second matrix): ");
                // Declares an integer, columnsSecondMatrix, as the given valid input
                int columnsSecondMatrix = validateInteger(input, "Enter the number of columns for the second matrix: ");

                // Declares a 2D integer array, firstMatrix, with the size of rowsFirstMatrix by columnsFirstMatrix
                int[][] firstMatrix = new int[rowsFirstMatrix][columnsFirstMatrix];
                // Declares a 2D integer array, secondMatrix, with the size of columnsFirstMatrix by columnsSecondMatrix
                int[][] secondMatrix = new int[columnsFirstMatrix][columnsSecondMatrix];

                // Calls the fillMatrix method to update the values of all the elements in firstMatrix
                fillMatrix(input, firstMatrix, "First Matrix");
                // Calls the fillMatrix method to update the values of all the elements in secondMatrix
                fillMatrix(input, secondMatrix, "Second Matrix");

                // Calls the printMatrix method to print the values of all the elements in firstMatrix
                printMatrix(firstMatrix, "First Matrix");
                // Calls the printMatrix method to print the values of all the elements in secondMatrix
                printMatrix(secondMatrix, "Second Matrix");

                // Calls the matrixMultiply method to return the multiplied matrix, given the firstMatrix, secondMatrix, rowsFirstMatrix, columnsFirstMatrix, and columnsSecondMatrix
                matrixMultiply(firstMatrix, secondMatrix, rowsFirstMatrix, columnsFirstMatrix, columnsSecondMatrix);
            }
        } catch (Exception e) {
            System.out.print("Invalid input. Please try again. ");
        }
    }
}

/*
PSEUDOCODE:
START

  FUNCTION matrixMultiply(firstMatrix, secondMatrix, rowsFirstMatrix, columnsFirstMatrix, columnsSecondMatrix)
    CREATE resultMatrix of size rowsFirstMatrix x columnsSecondMatrix

    FOR each row in firstMatrix
      FOR each column in secondMatrix
        FOR each element in corresponding row and column
          MULTIPLY the values from both matrices and add to resultMatrix
        END FOR
      END FOR
    END FOR

    PRINT "Resultant Matrix"
    PRINT resultMatrix
  END FUNCTION

  FUNCTION getPositiveInteger(input, prompt)
    LOOP until valid input is entered
      DISPLAY prompt
      IF user input is valid integer
        IF the integer is greater than 0 or -1 (to exit)
          RETURN integer
        ELSE
          DISPLAY error message
      ELSE
        DISPLAY invalid input message
    END LOOP
  END FUNCTION

  FUNCTION fillMatrix(input, matrix, matrixName)
    DISPLAY message to enter values for the matrix
    FOR each row in matrix
      FOR each column in row
        PROMPT user for value
        IF value is valid
          ASSIGN value to matrix at row, column position
        ELSE
          DISPLAY error message
    END FOR
  END FUNCTION

  FUNCTION printMatrix(matrix, matrixName)
    DISPLAY matrixName
    FOR each row in matrix
      PRINT each value in row
    END FOR
  END FUNCTION

  FUNCTION main()
    CREATE Scanner object for input
    WHILE loop until user quits
      CALL getPositiveInteger for rows of first matrix
      IF -1 is entered, break the loop

      CALL getPositiveInteger for columns of first matrix and rows of second matrix
      CALL getPositiveInteger for columns of second matrix

      CREATE firstMatrix and secondMatrix based on dimensions

      CALL fillMatrix to populate both matrices

      CALL printMatrix to display both matrices

      CALL matrixMultiply to perform matrix multiplication and display result
    END LOOP
  END FUNCTION

END
 */