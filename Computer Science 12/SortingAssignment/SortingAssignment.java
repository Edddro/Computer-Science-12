/*
Name: Edward Drobnis
Title: Hockey Points Assignment
Description: Reads hockey team data, calculates points, and sorts using quicksort.
Date: April 21, 2025
*/

// Import libraries for file handling, Scanner, and StringTokenizer
import java.io.*;
import java.util.*;

// Class to represent a hockey team (name of team, games played, wins, losses, overtime losses, and points)
class Team {
    String name;
    int gamesPlayed, wins, losses, overtimeLosses, points;

    // Constructor to calculate the overtime losses and overall team points
    public Team(String name, int gamesPlayed, int wins, int losses) {
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.overtimeLosses = gamesPlayed - wins - losses;
        this.points = (wins * 2) + this.overtimeLosses;
    }

    // Print the team details as a string
    public String toString() {
        return String.format("%-12s %-15d %-15d %-15d %-20d %-15d", name, gamesPlayed, wins, losses, overtimeLosses, points);
    }
}

// Main class to read from input file, sort team points with quick sort, and write to output file
public class SortingAssignment {
    public static void main(String[] args) {
        try {
            // Open input file for reading and and output file for writing
            Scanner inputFile = new Scanner(new File("data.txt"));
            PrintWriter outputFile = new PrintWriter("output.txt");

            // Array to store up to 100 teams
            Team[] teams = new Team[100];
            // Number of valid teams read
            int teamCount = 0;

            // Skip lines that don't have at least 4 tokens (name + 3 numbers)
            while (inputFile.hasNextLine()) {
               StringTokenizer line = new StringTokenizer(inputFile.nextLine());
                if (line.countTokens() < 4) {
                    System.out.printf("Warning: Skipping incomplete line (line %s) %n", teamCount + 1);
                    continue;
                }
                // Ensures there are no more than 100 teams
                if (teamCount >= 100) {
                    System.out.println("Error: Maximum team limit of 100 exceeded.");
                    return;
                }

                try {
                    // Parse the line (and parse it into an integer)
                    String name = line.nextToken();
                    int gamesPlayed = Integer.parseInt(line.nextToken());
                    int wins = Integer.parseInt(line.nextToken());
                    int losses = Integer.parseInt(line.nextToken());
                    // Store team data
                    teams[teamCount++] = new Team(name, gamesPlayed, wins, losses);
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    System.out.printf("Warning: Skipping line with invalid input (line %s) %n", teamCount + 1);
                }
            }

            // If no valid teams are read
            if (teamCount == 0) {
                System.out.println("Error: No valid team data found in input file.");
                return;
            }

            // Sort the team array using QuickSort
            quickSort(teams, 0, teamCount - 1);

            // Print header row
            outputFile.printf("%-12s %-15s %-15s %-15s %-20s %-15s%n", "Team", "Games Played", "Wins", "Losses", "Overtime Losses", "Points");
            // Print sorted team information
            for (int i = 0; i < teamCount; i++) {
                outputFile.println(teams[i]);
            }

            System.out.println("Processing complete! Results saved in 'output.txt'.");

            // Close input and output files
            inputFile.close();
            outputFile.close();

            // Error handling - print appropiate error messages if necessary
        } catch (FileNotFoundException e) {
            System.out.println("Error: File 'data.txt' not found.");
        } catch (Exception e) {
            System.out.println("Error: Please try again.");
        }
    }

    // QuickSort implementation
    public static void quickSort(Team[] arr, int low, int high) {
        if (low < high) {
            // Partition the array
            int parts = partition(arr, low, high);
            // Sort left half
            quickSort(arr, low, parts - 1);
            // Sort right half
            quickSort(arr, parts + 1, high);
        }
    }

    // Partition helper method for QuickSort
    public static int partition(Team[] arr, int low, int high) {
        // Selecr pivot (last element)
        Team pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Compare and swap if needed
            if (compareTeams(arr[j], pivot) < 0) {
                i++;
                Team temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Final swap to place pivot in correct spot
        Team temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Compare two teams: sort by points (desc), then alphabetically by name (if a tie is present)
    public static int compareTeams(Team team1, Team team2) {
        if (team1.points != team2.points)
            return team2.points - team1.points;
        return team1.name.compareToIgnoreCase(team2.name);
    }
}

/*
PSEUDOCODE:

START
    TRY
        OPEN "data.txt" for reading as inputFile
        OPEN "output.txt" for writing as outputFile

        INITIALIZE Team array of size 100
        INITIALIZE teamCount to 0

        WHILE there are more lines in inputFile DO
            READ next line
            TOKENIZE the line (split into words)

            IF line has fewer than 4 tokens THEN
                PRINT "Warning: Skipping incomplete line"
                CONTINUE to next line
            ENDIF

            IF teamCount >= 100 THEN
                PRINT "Error: Maximum team limit exceeded"
                EXIT PROGRAM
            ENDIF

            TRY
                READ first token as team name
                CONVERT next token to integer gamesPlayed
                CONVERT next token to integer wins
                CONVERT next token to integer losses

                CALCULATE overtimeLosses = gamesPlayed - wins - losses
                CALCULATE points = (wins * 2) + overtimeLosses

                CREATE new Team object with data
                ADD Team to array at index teamCount
                INCREMENT teamCount
            CATCH NumberFormatException
                PRINT "Warning: Skipping line with invalid input"
            ENDTRY
        ENDWHILE

        IF teamCount == 0 THEN
            PRINT "Error: No valid team data found in input file."
            EXIT PROGRAM
        ENDIF

        CALL quickSort on Team array from index 0 to teamCount - 1

        WRITE header row to outputFile (team, games played, wins, losses, overtime losses, points)

        FOR i from 0 to teamCount - 1 DO
            WRITE Team[i] data to outputFile
        ENDFOR

        PRINT "Processing complete! Results saved in 'output.txt'."

        CLOSE inputFile
        CLOSE outputFile

    CATCH FileNotFoundException
        PRINT "Error: File 'data.txt' not found."
    CATCH Exception
        PRINT "Error: Please try again."
END
 */