class Main {
    public static int max(int[] ages) {
        int max = ages[0];

        for (int age : ages) {
            max = Math.max(max, age);
        }
        return max;
    }

    public static int min(int[] ages) {
        int min = ages[0];

        for (int age : ages) {
            min = Math.min(min, age);
        }
        return min;
    }

    public static int difference(int max, int min) {
        return max - min;
    }

    public static void main(String[] args) {
        int[] ages = new int[50];

        for (int i = 0; i < ages.length; i++) {
            ages[i] = (int)(Math.random() * 100) + 1;
        }
        int max = max(ages);
        int min = min(ages);
        int difference = difference(max, min);
        System.out.printf("The difference between %d and %d is: %d", max, min, difference);
    }
}