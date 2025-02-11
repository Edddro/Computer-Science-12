class Main {
    public static void main(String[] args)
    {
        int number = 1;
        while (number <= 5)
        {
            System.out.println(number);
            number++;
        }

        number = 10;
        do {
            System.out.println(number);
            number--;
        }
        while (number >= 5);

        System.out.println("------");

        for (int i = 1; i <= 10; i++)
        {
            System.out.println(i);
        }
    }
}