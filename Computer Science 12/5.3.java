import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter word to determine if palindrome: ");
        String word = input.nextLine();
        System.out.printf("Is %s a palindrome: %b", word, isPalindrome(word));
    }

    public static boolean isPalindrome(String str) {
            if (str.length() <= 1)
                return true;
            char firstChar = str.toLowerCase().charAt(0);
            char lastChar = str.toLowerCase().charAt(str.length() - 1);
            if (!Character.isLetter(firstChar))
                return isPalindrome(str.substring(1));
            if (!Character.isLetter(lastChar))
                return isPalindrome(str.substring(0, str.length() - 1));
            if (firstChar == lastChar)
                return isPalindrome(str.substring(1, str.length() - 1));
            else
                return false;
    }
}