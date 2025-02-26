/*
Name: Edward Drobnis
Date: February 25, 2025
Title: String Splitter
Description: Splits a string at a given sequence
*/

class Main {
    // Main method to split string
    public static void main(String[] args) {
        // Initializes a string, wc, with a sequence
        String wc = "Whooping crane";
        // Initializes a string array, sp, with the value of wc (having the oo removed)
        String[] sp = wc.split("oo");
        for(int j = 0; j < sp.length; j++)
        {
            System.out.println(sp[j]);
        }
    }
}