class Main {
    public static void main(String[] args) {
        int x = 3, p = 5, y = -8;

        switch(x)
        {
            case 2:
                p++;
            case 3:
            case 4:
                y+=(--p);
                break;
            case 5:
                y+=(p++);
        }
        System.out.println(y);

        char myChar = 'g';
        int yy = 0;
        switch(myChar) {
            case 'G':
            case 'g':
                yy++;
                break;
            case 'M':
            case 'm':
                --yy;
                break;
            default:
                yy += 100;
        }

        int z = 2, q = 0;
        switch(z)
        {
            case 1:
                q++;
            case 2:
                q++;
            case 3:
                q++;
            case 4:
                q++;
            default:
                q++;
        }
        System.out.println(--q);

        char chr = 'z';

        int a = 10, b = 12;
        System.out.println("The sum is " + a + b);
        System.out.println("The sum is " + (a + b));

        int speed = 75;
        switch(speed) {
        case 75:
            System.out.println("Exceeding speed limit");
            break;
        case 69:
        case 70:
            System.out.println("Getting close");
            break;
        case 65:
            System.out.println("Cruising");
            break;
        default:
            System.out.println("Very slow");
            break;
        }

        String s = "X";
        char ch_r = s.charAt(0);
    }
}