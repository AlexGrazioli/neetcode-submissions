class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int n: nums) {
            frequencies.put(n, frequencies.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] results = new int[k];
        int count = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int num : buckets[i]) {
                if (count == k) break;
                results[count++] = num;
            }
        }

        return results;
    }
}
