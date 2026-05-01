class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int caseOne = robWithRange(nums, 0, n - 1);
        int caseTwo = robWithRange(nums, 1, n);

        return Math.max(caseOne, caseTwo);
    }

    private int robWithRange(int[] nums, int startsFromInclusive, int endToExclusive) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = startsFromInclusive; i < endToExclusive; i++) {
            int currentMax = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = currentMax;
        }

        return prev1;
    }
}
