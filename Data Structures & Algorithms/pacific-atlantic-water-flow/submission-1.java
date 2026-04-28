class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int rowLength = heights.length;
        int colLength = heights[0].length;
        boolean[][] pacific = new boolean[rowLength][colLength];
        boolean[][]atlantic = new boolean[rowLength][colLength];

        for (int row = 0; row < rowLength; row++) {
            dfsWithBoolean(heights, row, 0, pacific, Integer.MIN_VALUE);
            dfsWithBoolean(heights, row, colLength - 1, atlantic, Integer.MIN_VALUE);
        }

        for (int col = 0; col < colLength; col++) {
            dfsWithBoolean(heights, 0, col, pacific, Integer.MIN_VALUE);
            dfsWithBoolean(heights, rowLength - 1, col, atlantic, Integer.MIN_VALUE);
        }

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private void dfsWithBoolean(int[][] heights, int row, int col, boolean[][] visited, int previousHeight) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) return;
        if (visited[row][col]) return;
        if (heights[row][col] < previousHeight) return;

        visited[row][col] = true;
        previousHeight = heights[row][col];
        
        dfsWithBoolean(heights, row + 1, col, visited, previousHeight);
        dfsWithBoolean(heights, row - 1, col, visited, previousHeight);
        dfsWithBoolean(heights, row, col + 1, visited, previousHeight);
        dfsWithBoolean(heights, row, col - 1, visited, previousHeight);
    }
}
