class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];

        for (int i = 1; i < nums.length;  i++) {
            int n = nums[i];
            if (n < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }
            
            minEnding = Math.min(nums[i] * minEnding, nums[i]);
            maxEnding = Math.max(nums[i] * maxEnding, nums[i]);

            result = Math.max(result, maxEnding);
        }

        return result;
    }
}
