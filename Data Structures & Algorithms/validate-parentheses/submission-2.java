class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                deque.push(c);
            } else if (deque.isEmpty() || pairs.get(deque.pop()) != c) {
                return false;
            }
        }

    return deque.isEmpty();
    }
}
