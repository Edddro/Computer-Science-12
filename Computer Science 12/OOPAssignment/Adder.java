/*
Name: Edward Drobnis
Date: March 19, 2025
Title: Adder
Description: The Adder game prompts the user for the answer to an addition problem
 */

import java.util.Scanner;

// Adder class to handle number generation, score tracking, and game logic
public class Adder {
    // Declares an integer, score, to store the number of points the player has earned
    int score;
    // Declares an integer, numberGuesses, to store the number of guesses remaining per round
    int numberGuesses;

    // Constructor (method) to initialize score and guess count
    public Adder() {
        // Sets score and numberGuesses in the called object to 0
        this.score = 0;
        this.numberGuesses = 0;
    }

    // Method, updateScore, for updating the object's score variable based on the value of the object's numberGuesses
    public void updateScore() {
        switch (this.numberGuesses) {
            case 0:
                // Increments score by 5, if the numberGuesses is 0 (first guess)
                this.score += 5;
                break;
            case 1:
                // Increments score by 3, if the numberGuesses is 1 (second guess)
                this.score += 3;
                break;
            case 2:
                // Increments score by 1, if the numberGuesses is 2 (third guess)
                this.score += 1;
                break;
        }
    }

    // Method, generateNumber, to generate and return a random integer between 0 and 20 (inclusive)
    public int generateNumber() {
        return (int) (Math.random() * 21);
    }

    // Method, playRound, to run a round of the game and validating user input
    public void playRound(int numberOne, int numberTwo, Scanner input) {
        System.out.printf("%d + %d = ", numberOne, numberTwo);
        // Creates an integer, answer, with the value being the sum of the two generated numbers
        int answer = numberOne + numberTwo;
        // Sets the value of numberGuesses to 0 when the playRound method is called
        this.numberGuesses = 0;

        // Prompts the user to guess the answer up to 3 times
        while (this.numberGuesses < 3) {
            if (input.hasNextInt()) {
                // Initalizes an integer, guess, with the value of input (a Scanner object)
                int guess = input.nextInt();
                input.nextLine();

                if (guess == 999) {
                    System.out.printf("Your score is: %d %n", this.score);
                    System.exit(0);
                } else if (0 <= guess && guess <= 40) {
                    if (guess == answer) {
                        this.updateScore();
                        break;
                    } else if (this.numberGuesses < 2) {
                        System.out.printf("Wrong answer. Enter another answer: ");
                    }
                    // Incremements numberGuesses by 1
                    this.numberGuesses++;
                } else {
                    System.out.printf("Guess must be an integer between 0 and 40: ");
                }
            } else {
                System.out.printf("Guess must be an integer between 0 and 40: ");
                input.nextLine();
            }
        }
    }
}

// Main class to execute the main program
class Main {
    // Initializes the main method
    public static void main(String[] args) {
        // Creates a Scanner object, input, to receive the value of the user input
        Scanner input = new Scanner(System.in);
        // Creates a Adder object, adder, to run the game and call functions in the Adder class
        Adder adder = new Adder();

        try {
            while (true) {
                // Initializes an integer, numberOne, with a value of a randomly generated number
                int numberOne = adder.generateNumber();
                // Initializes an integer, numberTwo, with a value of a randomly generated number
                int numberTwo = adder.generateNumber();
                // Calls the playRound method in the adder object, passing numberOne, numberTwo, and input
                adder.playRound(numberOne, numberTwo, input);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
PSEUDOCODE:
START

CLASS Adder
    DECLARE INTEGER score
    DECLARE INTEGER numberGuesses

    FUNCTION Adder()
        SET score TO 0
        SET numberGuesses TO 0
    END FUNCTION

    FUNCTION updateScore()
        SWITCH numberGuesses
            CASE 0:
                INCREMENT score BY 5
            CASE 1:
                INCREMENT score BY 3
            CASE 2:
                INCREMENT score BY 1
        END SWITCH
    END FUNCTION

    FUNCTION generateNumber() RETURNS INTEGER
        RETURN RANDOM INTEGER BETWEEN 0 AND 20 (inclusive)
    END FUNCTION

    FUNCTION playRound(numberOne, numberTwo, input)
        PRINT "numberOne + numberTwo = "
        SET answer TO numberOne + numberTwo
        SET numberGuesses TO 0

        WHILE numberGuesses < 3
            IF input IS AN INTEGER THEN
                SET guess TO input VALUE
                READ next input line

                IF guess == 999 THEN
                    PRINT "Your score is: score"
                    EXIT PROGRAM
                ELSE IF guess IS BETWEEN 0 AND 40 THEN
                    IF guess == answer THEN
                        CALL updateScore()
                        BREAK LOOP
                    ELSE IF numberGuesses < 2 THEN
                        PRINT "Wrong answer. Enter another answer: "
                    END IF
                    INCREMENT numberGuesses
                ELSE
                    PRINT "Guess must be an integer between 0 and 40: "
                END IF
            ELSE
                PRINT "Guess must be an integer between 0 and 40: "
                READ next input line
            END IF
        END WHILE
    END FUNCTION
END CLASS

CLASS Main
    FUNCTION main()
        DECLARE Scanner input
        DECLARE Adder adder

        TRY
            WHILE TRUE
                DECLARE INTEGER numberOne = CALL adder.generateNumber()
                DECLARE INTEGER numberTwo = CALL adder.generateNumber()
                CALL adder.playRound(numberOne, numberTwo, input)
            END WHILE
        CATCH EXCEPTION e
            PRINT e
        END TRY
    END FUNCTION
END CLASS

END PROGRAM
 */