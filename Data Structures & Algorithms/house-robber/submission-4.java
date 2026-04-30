class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int rob(int[] nums) {
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (cache.containsKey(i)) return cache.get(i);
        
        int result = Math.max(nums[i] + dfs(nums, i + 2), dfs(nums, i + 1));

        cache.put(i, result);

        return result;
    }
}
