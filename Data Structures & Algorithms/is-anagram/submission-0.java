class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sMap.containsKey(sChar)) {
                Integer sValue = sMap.get(sChar);
                sMap.put(sChar, ++sValue);    
            } else {
                sMap.put(sChar, 1);
            }

            if (tMap.containsKey(tChar)) {
                Integer tValue = tMap.get(tChar);
                tMap.put(tChar, ++tValue);    
            } else {
                tMap.put(tChar, 1);
            }
        }
        if (sMap.equals(tMap)) {
            return true;
        }
        return false;
    }
}
