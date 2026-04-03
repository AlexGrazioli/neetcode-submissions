class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int tempArea = 0;
        int i = 0;
        int j = heights.length - 1;
        
        while (i < j) {
            tempArea = (j - i) * Math.min(heights[i], heights[j]);
            maxArea = Math.max(maxArea, tempArea);
            if (heights[i] > heights[j]) j--; else if (heights[i] < heights[j]) i++; else {i++; j--;}
        }

        return maxArea;
    }
}
