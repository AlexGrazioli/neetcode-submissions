class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        int rowLength = heights.length;
        int columnLength = heights[0].length;

        for (int column = 0; column < columnLength; column++) {
            dfs(heights, 0, column, pacific, Integer.MIN_VALUE);
            dfs(heights, rowLength - 1, column, atlantic, Integer.MIN_VALUE);
        }

        for (int row = 0; row < rowLength; row++) {
            dfs(heights, row, 0, pacific, Integer.MIN_VALUE);
            dfs(heights,row, columnLength - 1, atlantic, Integer.MIN_VALUE);
        }

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                if (pacific.contains(row + "," + col) && atlantic.contains(row + "," + col)) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int column, Set<String> visited, int previousHeight) {
        if (row < 0 || row >= heights.length || column < 0 || column >= heights[0].length) return;
        if (visited.contains(row + "," + column)) return;
        if (heights[row][column] < previousHeight) return;
        visited.add(row + "," + column);

        previousHeight = heights[row][column];
        dfs(heights, row + 1, column, visited, previousHeight);
        dfs(heights, row - 1, column, visited, previousHeight);
        dfs(heights, row, column + 1, visited, previousHeight);
        dfs(heights, row, column - 1, visited, previousHeight);
    }
}
