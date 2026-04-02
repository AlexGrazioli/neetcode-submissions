class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        int result = 0;
        int temp = 1;

        for (Integer n : set) {
            if (set.contains(n+1)) {
                temp++;
            } else {
                result = Math.max(result, temp);
                temp = 1;
            }
        }

        return result;
    }
}
