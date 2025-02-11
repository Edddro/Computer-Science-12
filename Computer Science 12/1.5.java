import java.util.Random;

class Main {
    public static void main(String[] args)
    {
        Random rand = new Random();
        // print a random number from 0-99
        System.out.println(rand.nextInt(100));
        // print a random number from 0-1
        System.out.println(Math.random());
        System.out.printf("%.2f, %.2f, %.2f %n", Math.abs(-3843.0), Math.pow(9, 0.5), Math.sqrt(9));
    }
}