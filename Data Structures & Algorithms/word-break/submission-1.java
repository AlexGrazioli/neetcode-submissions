class Solution {
   TrieNode root = new TrieNode();

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            insert(word);
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && search(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public void insert(String word) {
        TrieNode pointer = root;

        for (int i = 0; i < word.length(); i++) {
            int number = word.charAt(i) - 'a';

            if (pointer.children[number] == null) pointer.children[number] = new TrieNode();

            pointer = pointer.children[number];
        }
        pointer.endOfWord = true;
    }

    private boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int number = word.charAt(i) - 'a';
            if (current.children[number] == null) return false;

            current = current.children[number];
        }

        return current.endOfWord;
    }
}
