class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Square of " + i + " = " + square(i));
        }
        print(1);
    }

    public static int square(int n) {
        return n*n;
    }

    public static void print(int n) {
        System.out.println(n);
    }
}