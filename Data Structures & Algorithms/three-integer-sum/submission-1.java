class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];

            while (j < k) {
                if (nums[j] + nums[k] < target) j++;
                else if (nums[j] + nums[k] > target) k--;
                else if (nums[j] + nums[k] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return result;
    }
}
