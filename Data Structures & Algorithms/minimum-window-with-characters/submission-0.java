class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();
        int j = 0;
        String result = "";

        for (Character c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int need = tFreq.size();
        int have = 0;

        for (int i = 0; i < s.length(); i++) {
            if (tFreq.containsKey(s.charAt(i))) {
                sFreq.put(s.charAt(i), sFreq.getOrDefault(s.charAt(i), 0) + 1);
                if (Objects.equals(sFreq.get(s.charAt(i)), tFreq.get(s.charAt(i)))) have++;
            }

            while (have == need) {
                if (result.isEmpty() || i - j + 1 < result.length()) result = s.substring(j, i + 1);
                if (tFreq.containsKey(s.charAt(j))) {
                    sFreq.put(s.charAt(j), sFreq.get(s.charAt(j)) - 1);
                    if (sFreq.get(s.charAt(j)) < tFreq.get(s.charAt(j))) have--;

                }
                j++;
            }

        }
        return result;
    }
}
