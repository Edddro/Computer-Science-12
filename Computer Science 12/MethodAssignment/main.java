/*
Name: Edward Drobnis
Date: February 11, 2025
Title: Method Assignment
Description: Methods for calculating math equations such as prime checks, GCF, and areas and volumes of geometric shapes.
 */

import java.util.Scanner;

class Main {
    public static int sum(int a, int b) {
        int greater = a;
        int smaller = b;
        int count = 0;

        if (a < b) {
            greater = b;
            smaller = a;
        }

        for (int i = smaller; i <= greater; i++) {
            count += i;
        }

        return count;
    }

    public static double factorial(int n) {
        double fact = 1;

        if (n == 0) {
            return 1;
        } else {
            for (double i = n; i >= 1; i--) {
                fact *= i;
            }
            return fact;
        }
    }

    public static Boolean isPrime(int n) {
        if (n % 2 == 0 && n != 2 || n == 1) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }

    public static int gcf(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static double average(int a, int b) {
        double avg = (double) (sum(a, b)) / (Math.abs(a - b) + 1);
        return (avg);
    }

    public static double triangleArea(int a, int b, int c) {
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }

    public static double mySqrt(int n) {
        double a = n / 2;
        double b = n / a;

        while (Math.abs(a - b) > 0.0001) {
            a = (a + b) / 2;
            b = n / a;
        }

        return a;
    }

    public static double rectangleArea(int a, int b) {
        return a * b;
    }

    public static double circleArea(int radius) {
        return Math.PI * radius * radius;
    }

    public static double sphereVolume(int radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public static double coneVolume(int radius, int height) {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

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

    public static void executeFunction(int choice) {
        Scanner inputs = new Scanner(System.in);
        int num1;
        int num2;
        int num3;

        switch (choice) {
            case 1:
                do {
                    System.out.print("Enter the first number: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                do {
                    System.out.print("Enter the second number: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num2 = inputs.nextInt();
                } while (num2 < 0);

                System.out.printf("Inclusive sum of %d and %d: %d %n", num1, num2, sum(num1, num2));
                break;

            case 2:
                do {
                    System.out.print("Enter a number: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                System.out.printf("Factorial of %d (%d!): %,.0f (%.4e) %n", num1, num1, factorial(num1), factorial(num1));
                break;

            case 3:
                do {
                    System.out.print("Enter a number: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                System.out.printf("Is %d Prime: %b %n", num1, isPrime(num1));
                break;

            case 4:
                do {
                    System.out.print("Enter the first number: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                do {
                    System.out.print("Enter the second number: ");

                    while (!inputs.hasNextInt()) {
                        System.out.printf("Enter a number greater than or equal to 0 and less than or equal to %d: ", num1);
                        inputs.next();
                    }

                    num2 = inputs.nextInt();
                } while (num2 < 1 || num1 < num2);

                System.out.printf("Greatest Common Factor between %d and %d: %d %n", num1, num2, gcf(num1, num2));
                break;

            case 5:
                do {
                    System.out.print("Enter the first number: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                do {
                    System.out.print("Enter the second number: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }

                    num2 = inputs.nextInt();
                } while (num2 < 0);

                System.out.printf("Average between %d and %d: %d %n", num1, num2, average(num1, num2));
                break;

            case 6:
                do {
                    System.out.print("Enter the first number (a): ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                do {
                    System.out.print("Enter the second number (b): ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }

                    num2 = inputs.nextInt();
                } while (num2 < 0);

                do {
                    System.out.print("Enter the third number (c): ");

                    while (!inputs.hasNextInt()) {
                        System.out.printf("Enter a number greater than or equal to 0 and less than or equal to %d: ", (num1 + num2));
                        inputs.next();
                    }

                    num3 = inputs.nextInt();
                    if (num3 > (num1 + num2)) {
                        System.out.printf("The third number must be less than %d. ", (num1 + num2 + 1));
                    }
                } while (num3 < 0 || num3 > (num1 + num2));

                System.out.printf("Area of a triangle (where a = %d, b = %d, c = %d): %n", num1, num2, num3, triangleArea(num1, num2, num3));
                break;

            case 7:
                do {
                    System.out.print("Enter a number: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                System.out.printf("Square root of %d: %.4f %n", num1, mySqrt(num1));
                break;

            case 8:
                do {
                    System.out.print("Enter the length: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                do {
                    System.out.print("Enter the width: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }

                    num2 = inputs.nextInt();
                } while (num2 < 0);

                System.out.printf("Area of a rectangle (where length = %d, width = %d): %,.4f %n", num1, num2, rectangleArea(num1, num2));

            case 9:
                do {
                    System.out.print("Enter the radius: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                System.out.printf("Area of cirlce with radius of %d: %.4f %n", num1, circleArea(num1));

            case 10:
                do {
                    System.out.print("Enter the radius: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                System.out.printf("Volume of sphere with radius of %d: %.4f %n", num1, sphereVolume(num1));

            case 11:
                do {
                    System.out.print("Enter the radius: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }
                    num1 = inputs.nextInt();
                } while (num1 < 0);

                do {
                    System.out.print("Enter the height: ");

                    while (!inputs.hasNextInt()) {
                        System.out.print("Enter a number greater than or equal to 0: ");
                        inputs.next();
                    }

                    num2 = inputs.nextInt();
                } while (num2 < 0);

                System.out.printf("Volume of cone with a radius of %d and height of %d: %.4f %n", num1, num2, coneVolume(num1, num2));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (true) {
            menu();
            System.out.print("Please enter your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();

                if (choice >= 1 && choice <= 12) {
                    if (choice == 12) {
                        System.out.println("Exiting program...");
                        break;
                    }

                    executeFunction(choice);
                } else {
                    System.out.printf("Invalid choice. Please enter a number from 1-12. %n");
                }
            } else {
                System.out.printf("Invalid input. Please enter a number from 1-12. %n");
                input.next();
            }
        }
        input.close();
    }
}