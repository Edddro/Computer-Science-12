import java.util.Scanner;

class Main {

    public static int[] highestMark(int[] marks) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you wish to enter: ");
        int size = sc.nextInt();

        int[] marks = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the mark of student %d: ", i + 1);
            marks[i] = sc.nextInt();
        }

        int[] sortedMarks = highestMark(marks);
        System.out.printf("The highest mark out of %d students is: %d %n", size, sortedMarks[0]);
        System.out.println("Marks: ");

        for (int mark: sortedMarks) {
            System.out.printf("%d %n", mark);
        }
    }
}