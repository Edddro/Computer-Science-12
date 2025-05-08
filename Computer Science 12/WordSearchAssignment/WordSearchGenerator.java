/*
Name: Edward Drobnis, David Liu, Nicholas Sorley
Title: Word Search Generator
Description: Generates a word search puzzle based on user-inputted words.
Date: May 7, 2025
*/

import java.io.*;
import java.util.*;

// Main class to display a menu, generate the word search, and solve the word search
public class WordSearchApp {
    // Placeholder value for unfilled cells
    private static final char EMPTY = ' ';
    // Letters used for randomly filling each unfilled cell in the puzzle
    private static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Main method to print and handle menu screen
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            // User Menu
            System.out.println("\nSelect one of the following options:");
            System.out.println("\tG - Generate a new puzzle");
            System.out.println("\tS - Solve an existing puzzle");
            System.out.println("\tQ - Quit");
            System.out.print("Enter choice: ");
            // Converts user's input into uppercase
            String choice = input.nextLine().trim().toUpperCase();

            // Calls the corresponding method based on user input
            if (choice.equals("G")) {
                puzzleGenerate(input);
            } else if (choice.equals("S")) {
                puzzleSolve(input);
            } else if (choice.equals("Q")) {
                System.out.println("Quitting program...");
                break;
            } else {
                System.out.println("Oops! That was not a valid option. Try again.");
            }
        }
        input.close();
    }

    // Check if a word can be placed starting at (row, column) in direction (direction_row,direction_column)
    private static boolean canPlace(char[][] sol, String w, int r, int c, int dr, int dc) {
        for (int i = 0; i < w.length(); i++) {
            // Computes the row and column indexes for the i-th character
            int rr = r + dr * i;
            int cc = c + dc * i;

            // Check if the position (rr, cc) is out of bounds
            if (rr < 0 || rr >= sol.length || cc < 0 || cc >= sol[0].length) {
                return false;
            }

            // Check if the cell is already occupied by a different letter
            if (sol[rr][cc] != EMPTY && sol[rr][cc] != w.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Generates the puzzle board, given the grid dimensions
    private static void puzzleGenerate(Scanner input) {
        System.out.println("\nWord Search Generator");
        // Reads word list from input file, saving it as an array list containing strings
        List<String> wordList = readWords(input, "Enter the word list file (e.g., words.txt): ");

        // Reads grid dimensions and ensures it's within range (between 10 and 20, inclusive)
        int rows = readNumber(input, "Number of rows (10-20): ", 10, 20);
        int cols = readNumber(input, "Number of columns (10-20): ", 10, 20);

        // Initialize puzzle and solution grids
        char[][] puzzle = new char[rows][cols];
        char[][] solution = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            // Fill the puzzle and solution boards with empty characters
            Arrays.fill(puzzle[r], EMPTY);
            Arrays.fill(solution[r], EMPTY);
        }

        // Define possible directions (8 directions total)
        int[] dr = {0, 1, 1, -1, 0, -1, -1, 1};
        int[] dc = {1, 0, 1, 1, -1, 0, -1, -1};
        Random rand = new Random();

        // Attempts to place each word in the grid (iterates through the word list)
        Iterator<String> wordIterator = wordList.iterator();
        while (wordIterator.hasNext()) {
            String word = wordIterator.next();

            // Considers both the forward and reversed versions of the word in the word list
            String[] variants = {word.toUpperCase(), new StringBuilder(word.toUpperCase()).reverse().toString()};
            boolean placed = false;
            for (String w : variants) {

                // Finds all valid placements for the current word in the grid and adds it to the candidates array list
                List<int[]> candidates = new ArrayList<>();
                for (int dir = 0; dir < dr.length; dir++) {
                    for (int r = 0; r < rows; r++) {
                        for (int c = 0; c < cols; c++) {
                            if (canPlace(solution, w, r, c, dr[dir], dc[dir])) {
                                candidates.add(new int[]{r, c, dir});
                            }
                        }
                    }
                }

                // Randomize the list of candidates to add variety
                Collections.shuffle(candidates, rand);

                // Chooses the best placement based on overlap (optimized for overlaps)
                int bestOverlap = -1;
                int[] bestPlacement = null;
                // Only considers the first 10 candidates (valid placements)
                int limit = Math.min(10, candidates.size());

                for (int i = 0; i < limit; i++) {
                    // Get the i-th candidate placement (contains row, col, direction index)
                    int[] cand = candidates.get(i);
                    // // Extract row, column, and direction from the candidate
                    int r = cand[0], c = cand[1], dir = cand[2];
                    // Count how many letters in the word would overlap with already-placed letters in the solution grid
                    int overlap = countOverlap(solution, w, r, c, dr[dir], dc[dir]);
                    // If this candidate has more overlap than any previous one, save it as the best so far
                    if (overlap > bestOverlap) {
                        bestOverlap = overlap;
                        bestPlacement = new int[]{r, c, dir};
                    }
                }

                // Place the word into the solution grid if valid placement found
                if (bestPlacement != null) {
                    int r = bestPlacement[0], c = bestPlacement[1], dir = bestPlacement[2];
                    for (int i = 0; i < w.length(); i++) {
                        solution[r + dr[dir] * i][c + dc[dir] * i] = w.charAt(i);
                    }
                    placed = true;
                    break;
                }
            }

            // Remove word from list if it was successfully placed or error if unable to place word
            if (placed) {
                wordIterator.remove();
            } else {
                System.out.println("Could not place: " + word);
            }
        }

        // Fill in remaining empty spaces with random letters
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (solution[r][c] != EMPTY) {
                    puzzle[r][c] = solution[r][c];
                } else {
                    puzzle[r][c] = ABC.charAt(rand.nextInt(ABC.length()));
                }
            }
        }

        // Output both solution and puzzle grids to files
        writeGrid(solution, input, "solution");
        writeGrid(puzzle, input, "puzzle");
        System.out.println("All done! Check your files for the new puzzle and solution.");
    }

    // Handles the puzzle-solving interface and process
    private static void puzzleSolve(Scanner input) {
        System.out.println("\nWord Search Solver");

        // Reads list of valid words from users-inputted input file
        List<String> wordList = readWords(input, "Enter the word list file (e.g., words.txt): ");
        // Reads the word search puzzle grid from user-inputted puzzle file
        char[][] grid = readGrid(input, "Enter the puzzle file (e.g., puzzle.txt): ");

        // Creates an instance of the solver class to find the words in the puzzle
        WordSearchSolver solver = new WordSearchSolver();
        solver.solvePuzzle(wordList, grid, input);
    }

    // Counts how many letters in a proposed word placement overlap with existing letters in the grid
    private static int countOverlap(char[][] grid, String word, int r, int c, int dr, int dc) {
        int overlap = 0;
        for (int i = 0; i < word.length(); i++) {
            int rr = r + dr * i;
            int cc = c + dc * i;
            // Increments overlap if the letter already in the grid matches the word's letter
            if (grid[rr][cc] == word.charAt(i)) {
                overlap++;
            }
        }
        return overlap;
    }

    // Reads and validates a list of words from the defined input file
    private static List<String> readWords(Scanner input, String prompt) {
        System.out.print(prompt);
        String fileName = input.nextLine().trim();
         // Preserves order and avoids duplicates
        Set<String> words = new LinkedHashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim().toUpperCase();
                // Validates word: only 4-8 alphabetic characters
                if (line.matches("^[A-Z]{4,8}$")) {
                    if (!words.add(line)) {
                        System.out.println("Duplicate word ignored: " + line);
                    }
                } else {
                    System.out.println("Invalid word ignored: " + line);
                }
            }
            // Error handling for file input/output
        } catch (IOException e) {
            System.out.println("Error reading file, please try again.");
            // Attempts reading the words again
            return readWords(input, prompt);
        }
        return new ArrayList<>(words);
    }

    // Reads an integer within a specified range from user input
    private static int readNumber(Scanner input, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int n = Integer.parseInt(input.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (Exception e) {
                // Ignored: loop will re-prompt
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    // Writes a character grid to a file (either puzzle or solution)
    private static void writeGrid(char[][] grid, Scanner input, String type) {
        System.out.print("Enter " + type + " file name (e.g., " + type + ".txt): ");
        String fname = input.nextLine().trim();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fname))) {
            for (char[] row : grid) {
                for (char ch : row) {
                    // If the cell is empty, add an empty character; otherwise, add the corresponding character
                    bw.write(ch == EMPTY ? ' ' : ch);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Couldn't write " + type + " file. Try again.");
            // Retry on failure
            writeGrid(grid, input, type);
        }
    }

    // Reads a grid of characters from a file into a 2D array (for solver)
    private static char[][] readGrid(Scanner input, String prompt) {
        System.out.print(prompt);
        String fname = input.nextLine().trim();
        // List to store each line (row) from the file
        List<String> lines = new ArrayList<>();
        // Tries reading the current line
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            String line;
            // Read each line from the file until the end and skip blank lines
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                lines.add(line);
            }
        } catch (IOException e) {
            // If an error occurs while reading, prompt the user again recursively
            System.out.println("Error reading puzzle. Try again.");
            return readGrid(input, prompt);
        }

        // Create a 2D char array with the number of rows equal to the number of lines
        char[][] grid = new char[lines.size()][];

        // Convert each line (a string) into a character array and store it in the grid
        for (int i = 0; i < lines.size(); i++) {
            grid[i] = lines.get(i).toCharArray();
        }
        return grid;
    }
}