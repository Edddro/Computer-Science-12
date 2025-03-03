/*
Author: Edward Drobnis
Date: March 2, 2025
Title: Calendar
Description: Prints a calendar for a given year
 */

import java.util.Scanner;

// Main class to print a calendar for the given year
class Calendar {

    // Method to return the starting day of the given month and year, using Zeller's Rule, as an integer
    public static int startDay(int month, int year) {
        // Declares an integer, day, as 1
        int day = 1;
        // Declares an integer, decade, as the last two numbers in the given year
        int decade = year % 100;
        // If the month is January or February, consider them as the 11th and 12th months of the previous year
        if (month == 1 || month == 2) {
            decade -= 1;
            month += 10;
        } else {
            month -= 2;
        }
        // Declares an integer, century, as the year with the last two digits removed
        int century = year / 100;
        // If the year ends with 00
        if (decade == -1) {
            decade = 99;
            century -= 1;
        }
        // Declares an integer, formula, which calculates the start day of the month (0-6)
        int formula = (day + ((13 * month - 1) / 5) + decade + (decade / 4) + (century / 4) - (2 * century)) % 7;
        return (formula + 7) % 7;
    }

    // Method to print the calendar for the given year, given the year, months, and days
    public static void calendar(int year, String[] months, int[] days) {
        // 1D String array, dayNames, to hold the string values of the names of each day in a week
        String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        System.out.printf("%" + ((117 + String.valueOf(year).length()) / 2) + "d %n", year);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.printf("%-35s", String.format("%" + (17 + months[row * 3 + col].length() / 2 + (6 * col)) + "s", months[row * 3 + col]));
            }
            System.out.println();

            for (int col = 0; col < 3; col++) {
                for (String day : dayNames) {
                    System.out.printf("%5s", day);
                }
                System.out.printf("%4s", " ");
            }
            System.out.println();

            // 2D integer array, startDays, to hold the starting values of each month (from 0-6)
            int[][] startDays = new int[4][3];

            for (int col = 0; col < 3; col++) {
                startDays[row][col] = startDay((row * 3) + col + 1, year);
            }

            for (int week = 0; week < 6; week++) {
                for (int col = 0; col < 3; col++) {
                    // Declares an integer, dayCount, which determnes the number of day the count is at
                    int dayCount = 1 + (week * 7) - startDays[row][col];

                    // If the counter is negative, print an empty value; otherwise, print the count
                    for (int day = 0; day < 7; day++) {
                        if (dayCount > 0 && dayCount <= days[(row * 3) + col]) {
                            System.out.printf("%5d", dayCount);
                        } else {
                            System.out.printf("%5s", " ");
                        }
                        dayCount++;
                    }
                    System.out.printf("%4s", " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Main method to print the calendar
    public static void main(String[] args) {
        // 1D String array, months, to hold the string values of the names of each month
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        // 1D integer array, days, to hold the number of days in each month
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter year (or -1 to quit): ");
                int year = input.nextInt();

                if (year > 0) {
                    // Set the number of days in February to 28 by default
                    days[1] = 28;
                    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                        // Set the number of days in February to 29 if the year is a leap year
                        days[1] = 29;
                    }
                    // Calls the calendar method to print the calendar, given the year, months, and days
                    calendar(year, months, days);
                } else if (year == -1) {
                    System.out.println("Exiting program...");
                    break;
                } else {
                    System.out.println("Year must be a positive integer.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Year must be a positive integer.");
                input.next();
            }
        }
        input.close();
    }
}

/*
PSEUDOCODE:
START

  FUNCTION startDay(month, year)
    SET day = 1
    SET decade = year % 100
    IF month == 1 OR month == 2
      DEC = decade - 1
      month = month + 10
    ELSE
      month = month - 2
    END IF
    SET century = year / 100
    IF decade == -1
      decade = 99
      century = century - 1
    END IF

    SET formula = (day + ((13 * month - 1) / 5) + decade + (decade / 4) + (century / 4) - (2 * century)) % 7
    RETURN (formula + 7) % 7
  END FUNCTION

  FUNCTION calendar(year, months, days)
    SET weekDays = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"]
    PRINT year centered

    FOR row = 0 TO 3
      FOR col = 0 TO 2
        PRINT month name centered for this column

      PRINT week day headers (Sun, Mon, Tue, Wed, Thu, Fri, Sat)

      SET startDays = 2D array (rows = 4, columns = 3)
      FOR col = 0 TO 2
        SET startDays[row][col] = startDay of that month

      FOR week = 0 TO 5
        FOR col = 0 TO 2
          SET dayCount = first day of the week for the month
          FOR day = 0 TO 6
            IF dayCount is within the valid day range
              PRINT dayCount
            ELSE
              PRINT blank space
            END IF
            dayCount++
          END FOR
          PRINT space between months
        END FOR
      END FOR

      PRINT empty line between month rows
    END FOR
  END FUNCTION

  SET months = ["January", "February", "March", ..., "December"]
  SET days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

  REPEAT
    PRINT "Enter year (or -1 to quit):"
    GET input year from user

    IF year > 0
      IF year is a leap year (check if divisible by 4 and not 100, or divisible by 400)
        SET days[1] = 29
      ELSE
        SET days[1] = 28
      END IF

      CALL calendar(year, months, days)  // Print the calendar for that year
    ELSE IF year == -1
      PRINT "Exiting program..."
      BREAK
    ELSE
      PRINT "Invalid year input"
    END IF
  UNTIL user inputs -1
END
 */