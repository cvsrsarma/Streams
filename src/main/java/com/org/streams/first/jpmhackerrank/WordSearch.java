package com.org.streams.first.jpmhackerrank;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        
        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true; // Word found
                }
            }
        }
        
        return false; // Word not found
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base case: If the index reaches the length of the word, the entire word has been found
        if (index == word.length()) {
            return true;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Check if the current cell is out of bounds or does not match the current character of the word
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Mark the current cell as visited by changing its value temporarily
        char temp = board[i][j];
        board[i][j] = '#';
        
        // Recursively search in all four directions
        boolean found = dfs(board, word, i - 1, j, index + 1) || // Up
                        dfs(board, word, i + 1, j, index + 1) || // Down
                        dfs(board, word, i, j - 1, index + 1) || // Left
                        dfs(board, word, i, j + 1, index + 1);   // Right
        
        // Restore the original value of the current cell
        board[i][j] = temp;
        
        return found;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String[] words = {"ABCCED", "SEE", "ABCB"};
        for (String word : words) {
            System.out.println("Word: " + word + ", Exists: " + solution.exist(board, word));
        }
    }

}
