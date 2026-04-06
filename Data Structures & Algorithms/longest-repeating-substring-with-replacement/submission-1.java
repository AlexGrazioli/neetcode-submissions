class Solution {
   public int characterReplacement(String s, int k) {
        int longest = 0;
        int i = 0;
        int[] count = new int[26];
        int maxFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(j) - 'A']);

            if ((j - i + 1) - maxFreq > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }

            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }
}
