class Solution {
 private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode pointer = root;

        for (int i = 0; i < word.length(); i++) {
            int number = word.charAt(i) - 'a';

            if (pointer.children[number] == null) pointer.children[number] = new TrieNode();

            pointer = pointer.children[number];
        }
        pointer.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) insert(word);

        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[0].length; col++)
                backtrack(board, root, row, col, result, new HashSet<>());

        return result;
    }

    private void backtrack(char[][] board, TrieNode node, int row, int col,
                           List<String> result, Set<String> visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (visited.contains(row + "," + col)) return;

        int index = board[row][col] - 'a';
        if (node.children[index] == null) return;

        TrieNode nextNode = node.children[index];

        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // prevent duplicates
        }

        visited.add(row + "," + col);
        backtrack(board, nextNode, row, col + 1, result, visited);
        backtrack(board, nextNode, row, col - 1, result, visited);
        backtrack(board, nextNode, row + 1, col, result, visited);
        backtrack(board, nextNode, row - 1, col, result, visited);
        visited.remove(row + "," + col);
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
}
