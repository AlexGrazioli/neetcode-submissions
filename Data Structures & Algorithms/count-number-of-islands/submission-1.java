class Solution {
        public int numIslands(char[][] grid) {
        int result = 0;
        Set<String> visited = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && !visited.contains(row + "," + col)) {
                    result++;
                    dfs(grid, row, col, visited);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int row, int col, Set<String> visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if (visited.contains(row + "," + col)) return;
        if (grid[row][col] == '0') return;

        visited.add(row + "," + col);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }
}
