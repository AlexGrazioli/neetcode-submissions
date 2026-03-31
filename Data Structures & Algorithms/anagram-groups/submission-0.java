class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs.length < 2){
            result.add(Arrays.asList(strs[0]));
            return result;
        }

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) continue;
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i] != null && strs[j] != null && isAnagram(strs[i], strs[j])) {
                    temp.add(strs[j]);
                    strs[j] = null;
                }
            }
            strs[i] = null;

            result.add(temp);
        }
        return result;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            count.put(a.charAt(i), count.getOrDefault(a.charAt(i), 0) + 1);
            count.put(b.charAt(i), count.getOrDefault(b.charAt(i), 0) - 1);
        }
        return count.values().stream().allMatch(v -> v == 0);
    }
}
