/*
Name: Edward Drobnis, David Liu, Nicholas Sorley
Title: Word Search Generator
Description: Solves a word search puzzle based on user-inputted words.
Date: May 7, 2025
*/

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.*;
import java.util.List;

// Main class for solving the Word Search puzzle
public class WordSearchSolver {
    // Direction vectors for 8 possible search directions (E, S, SE, NW, W, N, NW, SW)
    private static final int[] dr = {0, 1, 1, -1, 0, -1, -1, 1};
    private static final int[] dc = {1, 0, 1, 1, -1, 0, -1, -1};

    // Main method to solve the puzzle
    public void solvePuzzle(List<String> wordList, char[][] grid, Scanner input) {
        // Starts timing in milliseconds
        long startTime = System.nanoTime();

        int rows = grid.length;
        int cols = grid[0].length;
        // Stores found words and their positions
        Map<String, List<int[]>> foundWords = new LinkedHashMap<>();

        // Preprocess: map each letter to its grid positions for faster search
        Map<Character, List<int[]>> letterPositions = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Get the letter at position (r, c)
                char letter = grid[r][c];

                // Check if the map already has this letter, if not create a new array list
                if (!letterPositions.containsKey(letter)) {
                    letterPositions.put(letter, new ArrayList<>());
                }

                // Add the current position to the list of positions for this letter
                List<int[]> positions = letterPositions.get(letter);
                positions.add(new int[]{r, c});
            }
        }

        // Loop through each word in the list
        for (String word : wordList) {
            String upper = word.toUpperCase();
            int len = upper.length();
            boolean found = false;

            // Try to find the word in both normal and reversed directions
            for (int reverseOption = 0; reverseOption < 2; reverseOption++) {
                boolean reversed = (reverseOption == 1);
                char[] target;

                if (reversed) {
                    // Reverse the word and convert it to a character array
                    String reversedWord = new StringBuilder(upper).reverse().toString();
                    target = reversedWord.toCharArray();
                } else {
                    // Use the word as-is
                    target = upper.toCharArray();
                }

                // Get the list of starting positions for the first letter of the word
                List<int[]> possibleStartingPoints = letterPositions.getOrDefault(target[0], Collections.emptyList());

                // Loop through all starting positions in the grid
                for (int[] startPosition : possibleStartingPoints) {
                    int startRow = startPosition[0];
                    int startCol = startPosition[1];

                    // Try each of the 8 possible directions (up, down, left, right, and diagonals)
                    for (int directionIndex = 0; directionIndex < 8; directionIndex++) {
                        int rowDirection = dr[directionIndex];
                        int colDirection = dc[directionIndex];

                        // Calculate the row and column of the last letter in the word
                        int endRow = startRow + rowDirection * (len - 1);
                        int endCol = startCol + colDirection * (len - 1);

                        // Check if the word would go outside the grid in this direction
                        if (endRow < 0 || endRow >= rows || endCol < 0 || endCol >= cols) {
                            continue;
                        }

                        // Check if each character in the word matches the grid
                        boolean allLettersMatch = true;
                        for (int i = 0; i < len; i++) {
                            int currentRow = startRow + rowDirection * i;
                            int currentCol = startCol + colDirection * i;

                            // If any character doesn't match, stop checking this direction
                            if (grid[currentRow][currentCol] != target[i]) {
                                allLettersMatch = false;
                                break;
                            }
                        }

                        // If a match is found, store the word's path and stop searching
                        if (allLettersMatch) {
                            List<int[]> path = new ArrayList<>();
                            for (int i = 0; i < len; i++) {
                                path.add(new int[]{
                                        startRow + rowDirection * i,
                                        startCol + colDirection * i
                                });
                            }

                            foundWords.put(upper, path);
                            found = true;
                            break;
                        }
                    }

                    // If word was found, no need to check more starting positions
                    if (found) {
                        break;
                    }
                }

                if (!found)
                    System.out.println("Did not find " + word);
            }
        }
        // End timing and calculate time duration
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        // Visualize the solution (open Java Swing window)
        showSwingGrid(grid, foundWords, duration);
        System.out.println("Success! Check the window for highlighted words.");
    }

    // Visualizes the word search puzzle with highlighted found words using Swing GUI
    private void showSwingGrid(char[][] grid, Map<String, List<int[]>> found, long duration) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Stores which cells to highlight
        boolean[][] highlight = new boolean[rows][cols];

        // Mark all cells that are part of found words
        for (var entry : found.values()) {
            for (int[] cell : entry) {
                highlight[cell[0]][cell[1]] = true;
            }
        }

        // Convert char grid to String grid for JTable
        String[][] data = new String[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                data[r][c] = String.valueOf(grid[r][c]);

        // Create column names (empty, just placeholders)
        String[] columnNames = new String[cols];
        Arrays.fill(columnNames, "");

        // Create non-editable JTable
        JTable table = new JTable(data, columnNames) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        // Table formatting and appearance
        table.setTableHeader(null);
        table.setRowHeight(30);
        table.setFont(new Font("Monospaced", Font.PLAIN, 24));
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);
        table.setIntercellSpacing(new Dimension(1, 1));

        // Custom cell renderer to highlight found words
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                comp.setBackground(highlight[row][column] ? Color.GREEN : Color.WHITE);
                comp.setFont(comp.getFont().deriveFont(highlight[row][column] ? Font.BOLD : Font.PLAIN));
                setHorizontalAlignment(SwingConstants.CENTER);
                setBorder(BorderFactory.createLineBorder(Color.BLACK));
                return comp;
            }
        };

        // Apply custom renderer to all columns
        for (int c = 0; c < cols; c++) {
            table.getColumnModel().getColumn(c).setCellRenderer(renderer);
            table.getColumnModel().getColumn(c).setPreferredWidth(30);
        }

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);

        // Calculate preferred size
        int tableWidth = cols * 31 + 2;
        int tableHeight = rows * 31 + 2;

        // Create and show GUI frame
        JFrame frame = new JFrame("Word Search Result - " + duration + " ms");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(scrollPane);
        frame.setSize(tableWidth, tableHeight + 40);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}