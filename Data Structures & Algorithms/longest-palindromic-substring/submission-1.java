class Solution {
    String longestPalindrome = "";
    String currentPalindrome = "";
    
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        for (int i = 0; i < s.length(); i++) {
            expandAroundTheCenter(s, i, i);
            if (currentPalindrome.length() >= longestPalindrome.length()) longestPalindrome = currentPalindrome;
            
            expandAroundTheCenter(s, i, i + 1);
            if (currentPalindrome.length() >= longestPalindrome.length()) longestPalindrome = currentPalindrome;
        }

        return longestPalindrome;
    }

    private void expandAroundTheCenter(String s, int left, int right) {
        while (left >= 0 & right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (currentPalindrome.length() <= s.substring(left, right + 1).length()) {
                currentPalindrome = s.substring(left, right + 1);
            }
            left--;
            right++;
        }   
    }
}
