class Solution {
    public boolean exist(char[][] board, String word) {
                for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, word, 0, row, col, new HashSet<>())) return true;
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int row, int col, Set<String> visited) {
        if (i == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (visited.contains(row + ", " + col)) return false;
        if (board[row][col] != word.charAt(i)) return false;

        visited.add(row + ", " + col);

        boolean found = backtrack(board, word, i + 1, row, col + 1, visited)
                || backtrack(board, word, i + 1, row, col - 1, visited)
                || backtrack(board, word, i + 1, row + 1, col, visited)
                || backtrack(board, word, i + 1, row - 1, col, visited);

        visited.remove(row + ", " + col);

        return found;
    }
}
