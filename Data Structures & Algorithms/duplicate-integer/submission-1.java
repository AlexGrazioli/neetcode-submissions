class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

        for (int num : nums) {
            table.put(num, num);
        }
        if (nums.length == table.size()) {
            return false;
        }
        return true;
    }
}