/*
Name: Edward Drobnis
Date: February 11, 2025
Title: Method Assignment
Description: Methods for calculating math equations such as prime checks, GCF, and areas and volumes of geometric shapes.
 */

import java.util.Scanner;

class Main {
    public static int sum(int a, int b) {
        return a + b;
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

    public static double average(double a, double b) {
        return (a + b) / 2;
    }

    public static double triangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }

    public static double mySqrt(double n) {
        double a = n / 2;
        double b = n / a;

        while (Math.abs(a - b) > 0.0001) {
            a = (a + b) / 2;
            b = n / a;
        }

        return a;
    }

    public static double rectangleArea(double a, double b) {
        return a * b;
    }

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double sphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public static double coneVolume(double radius, double height) {
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

//        System.out.printf("n + n = %d %n", sum(1, 2));
//        System.out.printf("n!: %,.0f (%.4e) %n", factorial(50), factorial(50));
//        System.out.printf("Is n Prime: %b %n", isPrime(11));
//        System.out.printf("Greatest Common Factor between a and b: %d %n", gcf(38, 88)); // MAKE SURE A > B, b cannot equal 0
//        System.out.printf("Average of n and n2: %f %n", average(1, 2));
//        System.out.printf("Area of a triangle (where a = a, b = b, c = c): %.4f %n", triangleArea(3, 4, 5)); // Check a + b > c where c is the largest side
//        System.out.printf("Square root of n: %.4f %n", mySqrt(5));
//        System.out.printf("Area of a rectangle (where a = a and b = b): %.4f %n", rectangleArea(3, 4));
//        System.out.printf("Area of cirlce (where the radius is n): %.4f %n", circleArea(5));
//        System.out.printf("Volume of sphere (where the radius is n): %.4f %n", sphereVolume(5));
//        System.out.printf("Volume of cone (where the radius is n and height is y): %.4f %n", coneVolume(5, 5));
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