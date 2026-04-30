class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int rob(int[] nums) {
        int[] cache = new int[nums.length];

        if (nums.length == 1) return nums[0];

        cache[0] = nums[0];
        cache[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            cache[i] = Math.max(nums[i] + cache[i - 2], cache[i - 1]);
        }

        return cache[nums.length - 1];
    }
}
