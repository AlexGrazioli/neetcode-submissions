class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;

}            

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode pointer = root;

        for (char c: word.toCharArray()) {
            pointer.children.putIfAbsent(c, new TrieNode());
            pointer = pointer.children.get(c);
        }

        pointer.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
}

    private boolean searchHelper(String word, int i, TrieNode node) {
        if (i == word.length()) return node.isEndOfWord;

        char c = word.charAt(i);

        if (c == '.') {
            // try every child
            for (TrieNode child : node.children.values()) {
                if (searchHelper(word, i + 1, child)) return true;
            }
            return false;
        } else {
            if (!node.children.containsKey(c)) return false;
            return searchHelper(word, i + 1, node.children.get(c));
        }
    }
}
