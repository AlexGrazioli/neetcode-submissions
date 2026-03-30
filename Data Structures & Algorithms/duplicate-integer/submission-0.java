class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> table = new HashMap();

        for (int num : nums) {
            table.put(num, num);
        }
        if (nums.length == table.size()) {
            return false;
        }
        return true;
    }
}