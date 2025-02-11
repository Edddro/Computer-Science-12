import java.util.Calendar;
import java.util.Scanner;

class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");

        System.out.print("Fire");
        System.out.println("Ants");

        /*
        %tB --> Full name of month
        %td --> 2-digit day of month, has leading zeros as needed
        %te --> 2-digit day of month, does not have leading zeros
        %ty --> 2-digit year
        %tY --> 4-digit year
        %tm --> Months in 2 digits, with leading zeros as necessary
        %tD --> Months as %tm %td %ty (month / day / year)
        %tl --> Hour in 12-hour clock
        %tM --> Minutes in 2 digits, with leading zeros as necessary
        %tp --> am/pm (lowercase)
         */

        Calendar cal = Calendar.getInstance();
        System.out.printf("%tB, %te, %tY %n", cal, cal, cal);
        System.out.printf("%tm, %td, %ty, %n", cal, cal, cal);
        System.out.printf("%tD, %n", cal);
        System.out.printf("%tl:%tM %tp %n", cal, cal, cal);

        Scanner input = new Scanner(System.in);
        System.out.print("Input: ");
        System.out.printf("Your input: %s%n", input.nextLine());
        input.close();
    }
}