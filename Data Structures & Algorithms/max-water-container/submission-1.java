class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0;
        int j = heights.length - 1;
        
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(heights[i], heights[j]));
            if (heights[i] >= heights[j]) j--; else i++;
        }

        return maxArea;
    }
}
