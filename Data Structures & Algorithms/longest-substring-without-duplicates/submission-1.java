class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) return 0;
        int longestSubstringLength = 1;
        int i = 0;
        int j = 1;
        Set<Character> visited = new HashSet<>();
        visited.add(s.charAt(0));

        while (j < s.length()) {
            if (visited.add(s.charAt(j))) {
                longestSubstringLength = Math.max(longestSubstringLength, visited.size());
                j++;
            } else {
                visited.remove(s.charAt(i));
                i++;
            }
        }

        return longestSubstringLength;
    }
}
