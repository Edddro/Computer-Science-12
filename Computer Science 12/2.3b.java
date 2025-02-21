import java.util.Scanner;

class Main {

    static int[] highestMark(int[] marks) {
        for (int i = 0; i < marks.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[max]) {
                    max = j;
                }
            }
            int temp = marks[i];
            marks[i] = marks[max];
            marks[max] = temp;
        }
        return marks;
    }

    static double[] highestMark(double[] marks) {
        for (int i = 0; i < marks.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[max]) {
                    max = j;
                }
            }
            double temp = marks[i];
            marks[i] = marks[max];
            marks[max] = temp;
        }
        return marks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[10];
        double[] marksDouble = new double[10];

        for (int i = 0; i < marks.length; i++) {
            System.out.printf("Enter the mark (as an integer) of student %d: ", i + 1);
            marks[i] = sc.nextInt();
        }

        for (int i = 0; i < marksDouble.length; i++) {
            System.out.printf("Enter the mark (with decimal places) of student %d: ", i + 1);
            marksDouble[i] = sc.nextDouble();
        }

        int[] sortedMarks = highestMark(marks);
        double[] sortedMarksDouble = highestMark(marksDouble);
        System.out.printf("The highest mark out of %d students is: %d %n", marks.length, sortedMarks[0]);
        System.out.println("Marks: ");

        for (int mark: sortedMarks) {
            System.out.printf("%d %n", mark);
        }

        System.out.printf("----------------%nThe highest mark out of %d students is: %.2f %n", marksDouble.length, sortedMarksDouble[0]);
        System.out.println("Marks: ");

        for (double mark: sortedMarksDouble) {
            System.out.printf("%.2f %n", mark);
        }
    }
}