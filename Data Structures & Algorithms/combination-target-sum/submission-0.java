class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int index = 0;

        backtrack(nums, target, index, current, result);

        return result;
    }

    private void backtrack(int[] nums, int target, int index,
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index >= nums.length) {
            // dead end
            return;
        }
        current.add(nums[index]);
        // include nums[index] — can reuse same index
        backtrack(nums, target - nums[index], index, current, result);
        current.removeLast();

        // skip nums[index] — move to next
        backtrack(nums, target, index + 1, current, result);
    }
}
