class Solution {
int numberOfPalindromicSubstrings = 0;

    public int countSubstrings(String s) {
        if (s == null) return 0;

        for (int i = 0; i < s.length(); i++) {

                expandAroundCenter(s, i, i + 1);
    
                expandAroundCenter(s, i, i);
            
        }

        return numberOfPalindromicSubstrings;
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            numberOfPalindromicSubstrings++;
            left--;
            right++;
        }
    }
}
