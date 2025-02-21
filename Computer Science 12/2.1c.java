import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String[] sandwiches = {"Veggie", "Plain", "Ham", "Cheese", "Pepperoni"};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the day: ");
        String dayName = input.nextLine();

        for(int i = 0; i < days.length; i++) {
            if(days[i].equalsIgnoreCase(dayName)){
                System.out.printf("The sandwich on discount on %s is: %s", days[i], sandwiches[i]);
                break;
            }
        }
    }
}