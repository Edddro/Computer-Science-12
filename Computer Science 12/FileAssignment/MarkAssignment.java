/*
Name: Edward Drobnis
Title: Mark Assignment
Description: Calculates the average grade for a student and class
Date: March 31, 2025
*/

import java.util.*;
import java.io.*;

// Reads student names and marks from a file, calculates averages, and outputs the processed data to a new file
class MarkAssignment {
    public static void main(String[] args) {
        try {
            // Open input file for reading and and output file for writing
            Scanner inputFile = new Scanner(new File("data.txt"));
            PrintWriter outputFile = new PrintWriter("marks.txt");

            // Check if the input file is empty
            if (!inputFile.hasNextLine()) {
                System.out.println("Error: The input file is empty.");
                return;
            }

            // Read the first line for subject names
            StringTokenizer tokenizer = new StringTokenizer(inputFile.nextLine());
            // Determine the number of subjects, limiting to a maximum of 8
            int subjectCount = Math.min(8, tokenizer.countTokens());
            // Ensure there is at least one subject; otherwise, exit
            if (subjectCount == 0) {
                System.out.println("Error: No subjects found in input file.");
                return;
            }

            // Write the table header (name and subjects)
            outputFile.format("%-15s %-15s", "First Name", "Last Name");
            for (int i = 0; i < subjectCount; i++) {
                outputFile.format("%-15s", tokenizer.nextToken());
            }
            outputFile.println("Average");

            // Initialize variables for the sum of grades in each subject and student count
            double[] subjectGrades = new double[subjectCount];
            double totalAvg = 0;
            int studentCount = 0;

            // Process each student's data
            while (inputFile.hasNextLine()) {
                tokenizer = new StringTokenizer(inputFile.nextLine());
                // Skips lines that have less than 3 tokens
                if (tokenizer.countTokens() < 3) continue;

                // Read student name
                String firstName = tokenizer.nextToken();
                String lastName = tokenizer.nextToken();
                double studentGradesSum = 0;

                outputFile.format("%-15s %-15s", firstName, lastName);

                // Read marks for each subject
                for (int subjectIndex = 0; subjectIndex < subjectCount; subjectIndex++) {
                    double mark = 0;
                    if (tokenizer.hasMoreTokens()) {
                        // Attempts to convert mark token as a double
                        try {
                            mark = Double.parseDouble(tokenizer.nextToken());
                        // If token cannot be converted into a double, set it to 0
                        } catch (NumberFormatException e) {
                            System.out.printf("Warning: Invalid mark found for %s %s. Setting mark to 0.%n", firstName, lastName);
                        }
                    }
                    // Add mark to student's and subjects grade
                    studentGradesSum += mark;
                    subjectGrades[subjectIndex] += mark;
                    outputFile.format("%-15.0f", mark);
                }

                // Calculate and print student average
                studentCount++;
                double studentAvg = studentGradesSum / subjectCount;
                totalAvg += studentAvg;
                outputFile.format("%.2f %n", studentAvg);
            }

            // Ensure at least one valid student is processed
            if (studentCount == 0) {
                System.out.println("Error: No valid student data found in input file.");
                return;
            }

            // Print subject averages
            outputFile.format("%-31s", "Average");
            for (double totalGrade : subjectGrades) {
                outputFile.format("%-15.2f", totalGrade / studentCount);
            }
            outputFile.format("%-15.2f %n", totalAvg / studentCount);

            System.out.println("Processing complete! Results saved in 'marks.txt'.");

            // Close input and output files
            inputFile.close();
            outputFile.close();

        // Error handling - print appropiate error messages if necessary
        } catch (FileNotFoundException e) {
            System.out.println("Error: File 'data.txt' not found.");
        } catch (Exception e) {
            System.out.println("Error: Please try again.");
        }
    }
}

/*
PSEUDOCODE
START
    TRY
        OPEN "data.txt" for reading as inputFile
        OPEN "marks.txt" for writing as outputFile

        IF inputFile is empty THEN
            PRINT "Error: The file is empty."
            EXIT PROGRAM
        ENDIF

        READ first line from inputFile (subject names)
        COUNT number of subjects (maximum of 8)

        IF subjectCount is 0 THEN
            PRINT "Error: No subjects found in the file."
            EXIT PROGRAM
        ENDIF

        WRITE "First Name", "Last Name", subject names, and "Average" to outputFile

        INITIALIZE totalGrades array of size subjectCount to store total marks per subject
        INITIALIZE totalAvg to store total average of all students
        INITIALIZE studentCount to 0

        WHILE there are more lines in inputFile DO
            READ next line
            TOKENIZE the line (split into words)

            IF the line has fewer than 3 tokens THEN
                SKIP to next line (continue loop)
            ENDIF

            READ first two tokens as firstName and lastName
            INITIALIZE studentTotal to 0

            WRITE firstName and lastName to outputFile

            FOR each subject (up to subjectCount) DO
                INITIALIZE mark to 0
                IF there are more tokens in the line THEN
                    TRY
                        CONVERT next token to a number and store in mark
                    CATCH NumberFormatException
                        PRINT "Warning: Invalid mark found for student. Setting mark to 0."
                    ENDTRY
                ENDIF

                ADD mark to studentTotal
                ADD mark to corresponding subject's total in totalGrades array
                WRITE mark to outputFile
            ENDFOR

            INCREMENT studentCount
            COMPUTE studentAvg as studentTotal / subjectCount
            ADD studentAvg to totalAvg
            WRITE studentAvg to outputFile
        ENDWHILE

        IF studentCount is 0 THEN
            PRINT "Error: No valid student data found."
            EXIT PROGRAM
        ENDIF

        WRITE "Average" and compute class average for each subject to outputFile
        WRITE overall class average to outputFile

        PRINT "Processing complete! Results saved in 'marks.txt'."

        CLOSE inputFile
        CLOSE outputFile

    CATCH FileNotFoundException
        PRINT "Error: File 'data.txt' not found."
    CATCH IOException
        PRINT "Error: Issue writing to file."
    CATCH Exception
        PRINT "An unexpected error occurred."
END
 */