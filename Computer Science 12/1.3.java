import java.util.Scanner;
class Main {
    public static void main(String[] args)
    {
        int i = 10;
        int j = 3;
        boolean true_false;

        true_false = (j > i);
        System.out.println(true_false);

        true_false = (i > j);
        System.out.println(true_false);

        true_false = (i == j);
        System.out.println(true_false);

        true_false = ((j <= i) || (j >= i ));
        System.out.println(true_false);

        true_false = ((i > j) && (j == 0));
        System.out.println(true_false);

        true_false = ((j < 50) || (j != 33));
        System.out.println(true_false);

        true_false = (!(j >= 0) || (i <= 50));
        System.out.println(true_false);

        true_false = (!(!(true)));
        System.out.println(true_false);

        true_false = (5 <= 5);
        System.out.println(true_false);

        true_false = (j != i);
        System.out.println(true_false);

        boolean b;
        int m = 45;
        b = (m <= 44);
        System.out.println(b);

        boolean e;
        int r = 17;
        e = (r > 17);
        System.out.println(e);

        System.out.println("-----");
        System.out.println(!((2 > 3) || (5 == 5) && (7 > 1) && (4 < 15) || (35 <= 36) && (89 != 34)));

        String s1 = "school BUS";
        if (s1.equals("school bus"))
            System.out.println("Equal");
        else
            System.out.println("Not equal");

        if (s1.equalsIgnoreCase("school bus"))
            System.out.println("Equal");
        else
            System.out.println("Not equal");

        int num1 = 19;
        int num2 = 200;
        if (num1 == 18)
            num2++;
        num1++;
        System.out.println(num1);
        System.out.println(num2);

        int g = 35;
        boolean check = (g == 34);
        System.out.println(check);

        int k = 12;
        boolean even = (k % 2 == 0);
        System.out.println(even);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        if (password.equals("XRay"))
            System.out.println("Password entered successfully.");
        else
            System.out.println("Password entered incorrect.");

        input.close();

        int number = 79;
        if (number > 50)
        {
            if (number < 60)
            {
                System.out.println("One");
            }
            else
            {
                System.out.println("Two");
            }
        }
        else
        {
            if (number > 30)
                System.out.println("Three");
            else
                System.out.println("Four");
        }

        Scanner integerNumber = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = integerNumber.nextInt();
        if (num % 2 == 0)
            System.out.println("The integer " + num + " is even");
        else
            System.out.println("The integer " + num + " is odd");
        integerNumber.close();
    }
}