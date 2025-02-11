import java.util.Scanner;

class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner("A string for testing scanner");
        System.out.println(sc.next());
        System.out.println(sc.findInLine("ri"));
        String ns = sc.next();
        System.out.println(ns);
        sc.useDelimiter("r\\s+");
        System.out.println(sc.next());
        sc.skip("r\\s*test");
        System.out.println(sc.next());

        String ss = "abcxyxydef";
        Scanner sc1 = new Scanner(ss);
        sc1.useDelimiter("xy");
        while(sc1.hasNext())
        {
            System.out.println(sc1.next());
        }

        String word = "d^^*_^^ir....-t***y";
        Scanner sc2 = new Scanner(word);
        sc2.useDelimiter("");
        String answer = "";
        while(sc2.hasNext())
        {
            while(sc2.hasNext("\\W|_"))
            {
                sc2.skip("_*");
                if(sc2.hasNext())
                    sc2.skip("\\W*");
            }
            if(sc2.hasNext())
                answer = answer + sc2.next();
        }
        System.out.println(answer);
    }
}