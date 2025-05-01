import java.io.*;
import java.util.*;

public class WordSearchApp {
    private static final char EMPTY = ' ';
    private static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nWhat would you like to do:");
            System.out.println("\tG - Generate a new puzzle");
            System.out.println("\tS - Solve an existing puzzle");
            System.out.println("\tQ - Quit");
            System.out.print("Enter your choice: ");
            String choice = input.nextLine().trim().toUpperCase();

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

    private static void puzzleGenerate(Scanner input) {
        System.out.println("\n--- Word Search Generator ---");
        List<String> wordList = readWords(input, "Enter the word list file (e.g., words.txt): ");
        int rows = readNumber(input, "How many rows (10-20)? ", 10, 20);
        int cols = readNumber(input, "How many columns (10-20)? ", 10, 20);

        char[][] puzzle = new char[rows][cols];
        char[][] solution = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            Arrays.fill(puzzle[r], EMPTY);
            Arrays.fill(solution[r], EMPTY);
        }

        // Directions: right, down, diag-down-right, diag-up-right
        int[] dr = {0, 1, 1, -1};
        int[] dc = {1, 0, 1, 1};
        Random rand = new Random();
        for (String word : wordList) {
            String w = word.toUpperCase();
            boolean placed = false;
            for (int attempt = 0; attempt < 100 && !placed; attempt++) {
                int dir = rand.nextInt(4);
                int r = rand.nextInt(rows);
                int c = rand.nextInt(cols);
                if (canPlace(solution, w, r, c, dr[dir], dc[dir])) {
                    for (int i = 0; i < w.length(); i++) {
                        solution[r + dr[dir]*i][c + dc[dir]*i] = w.charAt(i);
                    }
                    placed = true;
                }
            }
            if (!placed) {
                System.out.println("Could not place: " + word);
            }
        }

        // Copy solution to puzzle and fill empty with random letters
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (solution[r][c] != EMPTY) {
                    puzzle[r][c] = solution[r][c];
                } else {
                    puzzle[r][c] = ABC.charAt(rand.nextInt(ABC.length()));
                }
            }
        }

        writeGrid(solution, input, "solution");
        writeGrid(puzzle, input, "puzzle");
        System.out.println("All done! Check your files for the new puzzle and solution.");
    }

    private static void puzzleSolve(Scanner input) {
        System.out.println("\n--- Word Search Solver ---");
        List<String> wordList = readWords(input, "Enter the word list file (e.g., words.txt): ");
        char[][] grid = readGrid(input, "Enter the puzzle file (e.g., puzzle.txt): ");

        System.out.println("Words to find: " + wordList);

        // Directions: eight possible vectors (horizontal, vertical, diagonal)
        int[] dr = {0, 1, 1, -1, 0, -1, -1, 1};
        int[] dc = {1, 0, 1, 1, -1, 0, -1, -1};

        Map<String, List<int[]>> foundWords = new LinkedHashMap<>();
        for (String word : wordList) {
            String w = word.toUpperCase();
            boolean foundThis = false;
            System.out.println("Searching for: " + w);
            outer:
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    for (int d = 0; d < dr.length; d++) {
                        List<int[]> path = new ArrayList<>();
                        for (int i = 0; i < w.length(); i++) {
                            int rr = r + dr[d]*i;
                            int cc = c + dc[d]*i;
                            if (rr < 0 || rr >= grid.length || cc < 0 || cc >= grid[0].length
                                    || grid[rr][cc] != w.charAt(i)) {
                                path.clear();
                                break;
                            }
                            path.add(new int[]{rr, cc});
                        }
                        if (!path.isEmpty()) {
                            foundWords.put(w, path);
                            int[] start = path.get(0);
                            int[] end = path.get(path.size()-1);
                            System.out.println("Found " + w + " at [" + start[0] + "," + start[1] +
                                               "] to [" + end[0] + "," + end[1] + "]");
                            foundThis = true;
                            break outer;
                        }
                    }
                }
            }
            if (!foundThis) {
                System.out.println("Did NOT find " + w);
            }
        }

        writeHtml(grid, foundWords, input);
        System.out.println("Success! Check your HTML file for highlighted words.");
    }

    private static List<String> readWords(Scanner input, String prompt) {
        System.out.print(prompt);
        String fileName = input.nextLine().trim();
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) words.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file, please try again.");
            return readWords(input, prompt);
        }
        return words;
    }

    private static int readNumber(Scanner input, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int n = Integer.parseInt(input.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (Exception e) {}
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    private static boolean canPlace(char[][] sol, String w, int r, int c, int dr, int dc) {
        for (int i = 0; i < w.length(); i++) {
            int rr = r + dr*i;
            int cc = c + dc*i;
            if (rr < 0 || rr >= sol.length || cc < 0 || cc >= sol[0].length
                    || (sol[rr][cc] != EMPTY && sol[rr][cc] != w.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static void writeGrid(char[][] grid, Scanner input, String type) {
        System.out.print("Enter " + type + " file name (e.g., " + type + ".txt): ");
        String fname = input.nextLine().trim();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fname))) {
            for (char[] row : grid) {
                for (char ch : row) bw.write(ch == EMPTY ? ' ' : ch);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Couldn't write " + type + " file. Try again.");
            writeGrid(grid, input, type);
        }
    }

    private static char[][] readGrid(Scanner input, String prompt) {
        System.out.print(prompt);
        String fname = input.nextLine().trim();
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading puzzle. Try again.");
            return readGrid(input, prompt);
        }
        char[][] grid = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            grid[i] = lines.get(i).toCharArray();
        }
        return grid;
    }

    private static void writeHtml(char[][] grid, Map<String, List<int[]>> found, Scanner input) {
        System.out.print("Enter HTML output file name (e.g., result.html): ");
        String html = input.nextLine().trim();
        boolean[][] mark = new boolean[grid.length][grid[0].length];
        for (var entry : found.entrySet()) {
            for (var p : entry.getValue()) {
                mark[p[0]][p[1]] = true;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(html))) {
            writer.write("<html><head><meta charset='UTF-8'></head><body>");
            writer.write("<table border='1' cellpadding='4'>");
            for (int r = 0; r < grid.length; r++) {
                writer.write("<tr>");
                for (int c = 0; c < grid[0].length; c++) {
                    String cell = String.valueOf(grid[r][c]);
                    if (mark[r][c])
                        writer.write("<td style='background:yellow'><b>" + cell + "</b></td>");
                    else
                        writer.write("<td>" + cell + "</td>");
                }
                writer.write("</tr>");
            }
            writer.write("</table>");
            writer.write("</body></html>");
        } catch (IOException e) {
            System.out.println("Failed to write HTML. Try again.");
            writeHtml(grid, found, input);
        }
    }
}