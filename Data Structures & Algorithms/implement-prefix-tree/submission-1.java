public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode pointer = root;

        for (int i = 0; i < word.length(); i++) {
            int number = word.charAt(i) - 'a';
            if (pointer.children[number] != null) {
                pointer = pointer.children[number];
            } else {
                pointer.children[number] = new TrieNode();
                pointer = pointer.children[number];
            }
        }
        pointer.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int number = word.charAt(i) - 'a';
            if (current.children[number] == null) return false;

            current = current.children[number];
        }

        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); i++) {
            int number = prefix.charAt(i) - 'a';
            if (current.children[number] == null) return false;

            current = current.children[number];
        }

        return true;
    }
}
