class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            indexes.put(nums[i], i);
        }


        for(int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            
            if(indexes.containsKey(difference) && i != indexes.get(difference)) {
                return new int[] {i, indexes.get(difference)};
            }
        }
        return null;
    }
}
