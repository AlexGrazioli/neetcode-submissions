class PrefixTree {
    List<String> dictionary;

    public PrefixTree() {
        this.dictionary = new ArrayList<>();
    }

    public void insert(String word) {
        dictionary.add(word);
    }

    public boolean search(String word) {
        return dictionary.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String word : dictionary) {
            if (word.startsWith(prefix)) return true;
        }
        
        return false;
    }
}
