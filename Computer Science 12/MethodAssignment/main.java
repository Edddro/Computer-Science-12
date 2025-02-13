/*
Name: Edward Drobnis
Date: February 11, 2025
Title: Method Assignment
Description: Methods for calculating math equations such as prime checks, GCF, and areas and volumes of geometric shapes.
 */

import java.util.Scanner;

// Main class to continuously display the menu and call the corresponding methods until exited
class Main {
    // Method, sum, to calculate the sum of all integers between a and b, inclusive
    // Ensures the range is from the smaller value to larger value
    public static int sum(int a, int b) {
        // The greater variable is stored as an integer and holds the value of the larger inputted value
        // By default, it stores the value of the first integer inputted
        int greater = a;
        // The smaller variable is stored as an integer and holds the value of the smaller inputted value
        // By default, it stores the value of the second integer inputted
        int smaller = b;
        // The count variable is stored as an integer and keeps track of the
        // Cumulative sum of the integers between smaller and greater
        int count = 0;

        // If the value of the second inputted integer is greater than the value of the first inputted integer,
        // The values of greater and smaller change
        if (a < b) {
            greater = b;
            smaller = a;
        }

        // For loop to count from the smaller number up to the greater number
        // Increases the value of count by the current number in the iteration
        for (int i = smaller; i <= greater; i++) {
            count += i;
        }

        // Returns the value of the inclusive sum as an integer
        return count;
    }

    // Method, factorial, to calculate the factorial of a given number
    public static double factorial(int n) {
        // The fact variable is stored as a double and holds the result of the factorial
        double fact = 1;

        // Checks if the inputted integer is 0, if so it returns 1 as a double
        if (n == 0) {
            return 1;
        } else {
            // Otherwise, a for loop is executed, which loops from the inputted integer down to 1
            // The value of fact is multiplied by the current value of i, the loop iteration
            for (double i = n; i >= 1; i--) {
                fact *= i;
            }

            // Returns the value of fact as a double
            return fact;
        }
    }

    // Method, isPrime, to determine whether the given integer is a prime number
    // Returns a boolean (true or false)
    public static Boolean isPrime(int n) {
        // If the integer is divisible by 2 (even number) AND not 2 OR equal to 1, return false
        if (n % 2 == 0 && n != 2 || n == 1) {
            return false;
        } else {
            // Otherwise, a for loop is used to determine if the integer is divisible by any value from 2 up to the integer itself
            for (int i = 2; i < n; i++) {
                // If the integer is divisible by a value other than 1 and itself, return false
                if (n % i == 0)
                    return false;
            }
            // If no value was returned, return true
            return true;
        }
    }

    // Method, gcf, to calculate the Greatest Common Factor between two inputted integers
    // Returns an integer
    public static int gcf(int a, int b) {
        // Loops until the value of b, the second inputted integer (which is later given a new value), is 0
        while (b != 0) {
            // Creates a new integer, temp, which holds the value of b
            int temp = b;
            // Sets the new value of b to the remainder of the first integer (a) divided by the second integer (b)
            b = a % b;
            // Sets the value of a to the value of temp
            a = temp;
        }
        // Returns the value of a as an integer
        return a;
    }

    // Method, average, to calculate the inclusive average between two inputted integers
    public static double average(int a, int b) {
        // Creates a double, avg, which holds the value of the inclusive average
        // The inclusive average is calculated by receiving the inclusive sum from the sum function
        // And dividing it by the absolute value of the first integer - the second integer + 1
        // For example, if a = 6 and b = 5, it will calculate 2 (5 and 6)
        double avg = (double) (sum(a, b)) / (Math.abs(a - b) + 1);
        // Returns the value of avg as a double
        return avg;
    }

    // Method, triangleArea, which returns the area of a triangle as a double
    public static double triangleArea(int a, int b, int c) {
        // Creates a variable, s, which is stored as a double and is calculated by adding
        // The values of all 3 inputted integers divided by 2
        double s = (double)(a + b + c) / 2.0;
        // Creates a variable, area, which is stored as a double and is calculated using Heron's formula
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        // Returns the area of the triangle as a double
        return area;
    }

    // Method, mySqrt, which returns a double containing the value of the square root of the given integer
    public static double mySqrt(int n) {
        // Creates a variable, a, which holds the value of a double and is calculated by the given integer / 2
        double a = n / 2;
        // Creates a variable, b, which holds the value of a double and is calculated by the given integer / a
        double b = n / a;

        // Loops until the difference between a and b is less than 0.0001
        while (Math.abs(a - b) > 0.0001) {
            // Reassigns a new value to a by calculating the average of the two variables:
            a = (a + b) / 2;
            // Reassigns a new value to b by dividing the inputted integer by the new value of a
            b = n / a;
        }
        // Returns the value of a as a double
        return a;
    }

    // Method, rectangleArea, which returns the value of the area of a rectangle
    public static int rectangleArea(int a, int b) {
        // Returns the value of the area by multiplying the two inputted integers (a, the length and b, the width) as an integer
        return a * b;
    }

    // Method, circleArea, which returns the value of the area of a circle
    public static double circleArea(int radius) {
        // Returns the area of a circle by calculating pi * radius^2 (the inputted integer) as a double
        return Math.PI * radius * radius;
    }

    // Method, sphereVolume, which returns the value of the volume of a sphere
    public static double sphereVolume(int radius) {
        // Returns the volume of a sphere by calculating 4/3 * pi * radius^3 (the inputted integer) as a double
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Method, coneVolume, which returns the value of the volume of a cone
    public static double coneVolume(int radius, int height) {
        // Calculates the volume of a cone by calculating 1/3 * pi * radius^2 (the first inputted integer) * height (the second inputted integer) as a double
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    // Method, menu, which returns no value
    // Prints out a menu with all the options the user can choose from
    public static void menu() {
        System.out.println("\nChoose an option below from 1-12:");
        System.out.println("1. sum(a,b)");
        System.out.println("2. factorial(n)");
        System.out.println("3. isPrime(n)");
        System.out.println("4. gcf(a,b)");
        System.out.println("5. average(a,b)");
        System.out.println("6. triangleArea(a,b,c)");
        System.out.println("7. mySqrt(a)");
        System.out.println("8. rectangleArea(a,b)");
        System.out.println("9. circleArea(r)");
        System.out.println("10. sphereVolume(r)");
        System.out.println("11. coneVolume(r,h)");
        System.out.println("12. Exit");
    }

    // Method, getValidIntInput, which prompts the user for an integer inputed and ensures the value is valid
    // i.e., ensures the value is greater than or equal to 0
    public static int getValidIntInput(Scanner inputs, String prompt) {
        // Creates an integer, num, which does not hold any value
        int num;
        // Prints out the prompt (passed to the method in prompt as a String)
        // until the inputted value (passed to the method in inputs as a Scanner)
        // is an integer and greater than 0
        do {
            System.out.print(prompt);
            while (!inputs.hasNextInt()) {
                System.out.print("Enter a valid number greater than or equal to 0: ");
                inputs.next();
            }
            // Assigns the integer value to num
            num = inputs.nextInt();
        } while (num < 0);
        // Returns the value of the inputted valid integer
        return num;
    }

    // Method, executeFunction, which calls the corresponding function based on the chosen option
    public static void executeFunction(int choice) {
        // Creates a new Scanner object which receives a value from the usrr
        Scanner inputs = new Scanner(System.in);
        // Defines three integers, num1, num2, and num3, which hold no value
        int num1, num2, num3;

        // Try catch loop to ensure that all errors are handled
        try {
            // Switch case loop to call the corresponding function
            switch (choice) {
                // If the case is 1, it receives 2 integers, num1 and num2, and calls the sum method
                case 1:
                    num1 = getValidIntInput(inputs, "Enter the first number: ");
                    num2 = getValidIntInput(inputs, "Enter the second number: ");
                    System.out.printf("Inclusive sum of %,d and %,d: %,d %n", num1, num2, sum(num1, num2));
                    break;

                // If the case is 2, it receives 1 integer, num1, and calls the factorial function
                case 2:
                    num1 = getValidIntInput(inputs, "Enter a number: ");
                    System.out.printf("Factorial of %,d (%,d!): %,.0f (%.4e) %n", num1, num1, factorial(num1), factorial(num1));
                    break;

                // If the case is 3, it receives 1 integer, num1, and calls the isPrime function
                case 3:
                    num1 = getValidIntInput(inputs, "Enter a number: ");
                    System.out.printf("Is %,d Prime: %b %n", num1, isPrime(num1));
                    break;

                // If the case is 4, it receives 2 integers, num1 and num2 and calls the gcf method
                case 4:
                    num1 = getValidIntInput(inputs, "Enter the first number: ");
                   // Prompts the user for the second integer only once the first integer is valid
                    // The second integer, num2, must be less than or equal to num1 and greater than 0
                    do {
                        System.out.print("Enter the second number: ");

                        while (!inputs.hasNextInt()) {
                            System.out.printf("Please enter a valid integer greater than 0 and less than %d: ", num1 + 1);
                            inputs.next();
                        }

                        // Assigns the valid integer value to num2
                        num2 = inputs.nextInt();

                        // Checks if num2 is greater than num1, if so it prompts the user to enter a valid integer
                        if (num2 > num1) {
                            System.out.printf("Number must be less than %,d. %n", num1 + 1);
                        }

                        // Checks if num2 is less than 1, if so it prompts the user to input an integer greater than 0
                        if (num2 < 1) {
                            System.out.print("Number must be greater than 0. ");
                        }
                    } while (num2 > num1 || num2 < 1);
                    System.out.printf("Greatest Common Factor between %,d and %,d: %,d %n", num1, num2, gcf(num1, num2));
                    break;

                // If the case is 5, it receives two integers, num1 and num2, and the average method is called
                case 5:
                    num1 = getValidIntInput(inputs, "Enter the first number: ");
                    num2 = getValidIntInput(inputs, "Enter the second number: ");
                    System.out.printf("Average between %,d and %,d: %,.4f %n", num1, num2, average(num1, num2));
                    break;

                // If the case is 6, it receives three integers, num1, num2, num3, and tbe triangleArea method is called
                case 6:
                    num1 = getValidIntInput(inputs, "Enter the first number (a): ");
                    num2 = getValidIntInput(inputs, "Enter the second number (b): ");

                    // Prompts the user for the third integer once the other 2 are given
                    // and ensures that the third integer is greater than 0 and less than or equal to (num1 + num2)
                    do {
                        System.out.print("Enter the third number (c): ");
                        num3 = inputs.nextInt();
                        if (num3 > (num1 + num2)) {
                            System.out.printf("The third number must be less than %,d. %n", (num1 + num2 + 1));
                        }
                    } while (num3 < 0 || num3 > (num1 + num2));

                    // If the value of num3 is greater than (num1 + num2)
                    // OR the value of num2 is greater than (num1 + num3)
                    // OR the value of num1 is greater than (num2 + num3)
                    // Prompt the user to enter valid side lengths as a triangle cannot be formed with the given values
                    // Otherwise, call the triangleArea method
                    if (num1 + num2 < num3 || num1 + num3 < num2 || num2 + num3 < num1) {
                        System.out.println("These values do not form a valid triangle. Please enter valid sides.");
                    } else {
                        System.out.printf("Area of the triangle (where a = %,d, b = %,d, c = %,d): %,.4f %n", num1, num2, num3, triangleArea(num1, num2, num3));
                    }
                    break;

                // If the case is 7, it receives 1 integer, num1, and mySqrt method is called
                case 7:
                    num1 = getValidIntInput(inputs, "Enter a number: ");
                    System.out.printf("Square root of %d: %,.4f %n", num1, mySqrt(num1));
                    break;

                // If the case is 8, it receives 2 integers, num1 and num2, and rectangleArea method is called
                case 8:
                    num1 = getValidIntInput(inputs, "Enter the length: ");
                    num2 = getValidIntInput(inputs, "Enter the width: ");
                    System.out.printf("Area of a rectangle (where length = %d, width = %d): %,d %n", num1, num2, rectangleArea(num1, num2));
                    break;

                // If the case is 9, it receives 1 integer, num1, and circleArea method is called
                case 9:
                    num1 = getValidIntInput(inputs, "Enter the radius: ");
                    System.out.printf("Area of circle with radius of %d: %,.4f %n", num1, circleArea(num1));
                    break;

                // If the case is 10, it receives 1 integer, num1, and sphereVolume is called
                case 10:
                    num1 = getValidIntInput(inputs, "Enter the radius: ");
                    System.out.printf("Volume of sphere with radius of %d: %,.4f %n", num1, sphereVolume(num1));
                    break;

                // If the case is 11, it receives 2 integers, num1 and num2, and coneVolume is called
                case 11:
                    num1 = getValidIntInput(inputs, "Enter the radius: ");
                    num2 = getValidIntInput(inputs, "Enter the height: ");
                    System.out.printf("Volume of cone with a radius of %d and height of %d: %,.4f %n", num1, num2, coneVolume(num1, num2));
                    break;
            }
        } catch (Exception e) {
            System.out.println("Could not calculate as input is too large. Please try again with smaller numbers.");
        }
    }

    // Method, main, to continuously display the menu and call the corresponding methods
    public static void main(String[] args) {
        // Creates a Scanner, input, which receives input from the user
        Scanner input = new Scanner(System.in);
        // Creates an integer, choice, with a value of 0
        int choice = 0;

        // Loops indefinitely
        while (true) {
            // Calls the menu method to print the method
            menu();
            System.out.print("Please enter your choice: ");

            // Checks if the input is an integer, if so assign the integer to choice
            if (input.hasNextInt()) {
                choice = input.nextInt();

                // Checks if the choice is valid (between 1 and 12, inclusive)
                if (choice >= 1 && choice <= 12) {
                    // If the choice is 12, break out of the while true loop
                    if (choice == 12) {
                        System.out.println("Exiting program...");
                        break;
                    }

                    // Calls the executeFunction method to call the appropiate method
                    executeFunction(choice);
                } else {
                    System.out.printf("Invalid choice. Please enter a number from 1-12. %n");
                }
            } else {
                System.out.printf("Invalid input. Please enter a number from 1-12. %n");
                input.next();
            }
        }
        // Closes the scanner
        input.close();
    }
}

/*
PSEUDO CODE:
BEGIN Main

    FUNCTION sum(a, b)
        SET greater = max(a, b)
        SET smaller = min(a, b)
        SET count = 0

        FOR i FROM smaller TO greater
            count = count + i
        END FOR

        RETURN count
    END FUNCTION

    FUNCTION factorial(n)
        IF n == 0 THEN
            RETURN 1
        END IF

        SET fact = 1
        FOR i FROM n DOWNTO 1
            fact = fact * i
        END FOR

        RETURN fact
    END FUNCTION

    FUNCTION isPrime(n)
        IF n is even AND n != 2 OR n == 1 THEN
            RETURN false
        END IF

        FOR i FROM 2 TO n-1
            IF n MOD i == 0 THEN
                RETURN false
            END IF
        END FOR

        RETURN true
    END FUNCTION

    FUNCTION gcf(a, b)
        WHILE b != 0
            temp = b
            b = a MOD b
            a = temp
        END WHILE

        RETURN a
    END FUNCTION

    FUNCTION average(a, b)
        RETURN sum(a, b) / (absolute(a - b) + 1)
    END FUNCTION

    FUNCTION triangleArea(a, b, c)
        s = (a + b + c) / 2
        area = sqrt(s * (s - a) * (s - b) * (s - c))
        RETURN area
    END FUNCTION

    FUNCTION mySqrt(n)
        SET a = n / 2
        SET b = n / a

        WHILE absolute(a - b) > 0.0001
            a = (a + b) / 2
            b = n / a
        END WHILE

        RETURN a
    END FUNCTION

    FUNCTION rectangleArea(a, b)
        RETURN a * b
    END FUNCTION

    FUNCTION circleArea(radius)
        RETURN π * radius * radius
    END FUNCTION

    FUNCTION sphereVolume(radius)
        RETURN (4/3) * π * (radius^3)
    END FUNCTION

    FUNCTION coneVolume(radius, height)
        RETURN (1/3) * π * (radius^2) * height
    END FUNCTION

    FUNCTION menu()
        PRINT "Choose an option below from 1-12:"
        PRINT "1. sum(a,b)"
        PRINT "2. factorial(n)"
        PRINT "3. isPrime(n)"
        PRINT "4. gcf(a,b)"
        PRINT "5. average(a,b)"
        PRINT "6. triangleArea(a,b,c)"
        PRINT "7. mySqrt(a)"
        PRINT "8. rectangleArea(a,b)"
        PRINT "9. circleArea(r)"
        PRINT "10. sphereVolume(r)"
        PRINT "11. coneVolume(r,h)"
        PRINT "12. Exit"
    END FUNCTION

    FUNCTION getValidIntInput(inputs, prompt)
        DO
            PRINT prompt
            WHILE input is NOT a valid integer
                PRINT "Enter a valid number >= 0:"
                DISCARD invalid input
            END WHILE
            SET num = user input
        WHILE num < 0
        RETURN num
    END FUNCTION

    FUNCTION executeFunction(choice)
        CREATE scanner object inputs
        DECLARE num1, num2, num3

        TRY
            SWITCH(choice)
                CASE 1:
                    num1 = getValidIntInput(inputs, "Enter the first number: ")
                    num2 = getValidIntInput(inputs, "Enter the second number: ")
                    PRINT "Inclusive sum:", sum(num1, num2)
                    BREAK

                CASE 2:
                    num1 = getValidIntInput(inputs, "Enter a number: ")
                    PRINT "Factorial:", factorial(num1)
                    BREAK

                CASE 3:
                    num1 = getValidIntInput(inputs, "Enter a number: ")
                    PRINT "Is Prime:", isPrime(num1)
                    BREAK

                CASE 4:
                    num1 = getValidIntInput(inputs, "Enter the first number: ")
                    DO
                        PRINT "Enter the second number: "
                        WHILE input is NOT a valid integer
                            PRINT "Please enter a valid integer > 0 and < num1"
                            DISCARD invalid input
                        END WHILE
                        num2 = user input
                    WHILE num2 > num1 OR num2 < 1
                    PRINT "GCF:", gcf(num1, num2)
                    BREAK

                CASE 5:
                    num1 = getValidIntInput(inputs, "Enter the first number: ")
                    num2 = getValidIntInput(inputs, "Enter the second number: ")
                    PRINT "Average:", average(num1, num2)
                    BREAK

                CASE 6:
                    num1 = getValidIntInput(inputs, "Enter the first number (a): ")
                    num2 = getValidIntInput(inputs, "Enter the second number (b): ")
                    DO
                        PRINT "Enter the third number (c): "
                        num3 = user input
                    WHILE num3 < 0 OR num3 > (num1 + num2)

                    IF (num1 + num2 < num3) OR (num1 + num3 < num2) OR (num2 + num3 < num1)
                        PRINT "Invalid triangle sides."
                    ELSE
                        PRINT "Triangle Area:", triangleArea(num1, num2, num3)
                    END IF
                    BREAK

                CASE 7:
                    num1 = getValidIntInput(inputs, "Enter a number: ")
                    PRINT "Square root:", mySqrt(num1)
                    BREAK

                CASE 8:
                    num1 = getValidIntInput(inputs, "Enter the length: ")
                    num2 = getValidIntInput(inputs, "Enter the width: ")
                    PRINT "Rectangle Area:", rectangleArea(num1, num2)
                    BREAK

                CASE 9:
                    num1 = getValidIntInput(inputs, "Enter the radius: ")
                    PRINT "Circle Area:", circleArea(num1)
                    BREAK

                CASE 10:
                    num1 = getValidIntInput(inputs, "Enter the radius: ")
                    PRINT "Sphere Volume:", sphereVolume(num1)
                    BREAK

                CASE 11:
                    num1 = getValidIntInput(inputs, "Enter the radius: ")
                    num2 = getValidIntInput(inputs, "Enter the height: ")
                    PRINT "Cone Volume:", coneVolume(num1, num2)
                    BREAK
            END SWITCH
        CATCH exception
            PRINT "Input too large. Try again."
        END TRY
    END FUNCTION

    FUNCTION main()
        CREATE scanner object input
        DECLARE choice = 0

        LOOP FOREVER
            CALL menu()
            PRINT "Enter your choice: "

            IF input is an integer
                SET choice = user input
                IF choice BETWEEN 1 and 12
                    IF choice == 12
                        PRINT "Exiting program..."
                        BREAK
                    END IF
                    CALL executeFunction(choice)
                ELSE
                    PRINT "Invalid choice, enter between 1-12."
                END IF
            ELSE
                PRINT "Invalid input, enter a number between 1-12."
                DISCARD invalid input
            END IF
        END LOOP

        CLOSE scanner input
    END FUNCTION

END Main
 */