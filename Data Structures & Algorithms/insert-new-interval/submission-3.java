class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean isAdded = false;

        for (int[] interval : intervals) {
            if (isAdded || interval[1] < newInterval[0]) {
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                result.add(interval);
                isAdded = true;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        
        if (!isAdded) {
            result.add(newInterval);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
