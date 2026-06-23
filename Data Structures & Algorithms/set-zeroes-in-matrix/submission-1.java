class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> coordinates = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    coordinates.add(new int[]{i, j});
                }
            }
        }

        for (int[] coordinate : coordinates) {
            makeWholeRwoAndColumnZero(matrix, coordinate[0], coordinate[1]);
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    private void makeWholeRwoAndColumnZero(int[][] matrix, int row, int col) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        for (int i = 0; i < colLength; i++) {
            matrix[row][i] = 0;
        }

        for (int i = 0; i < rowLength; i++) {
            matrix[i][col] = 0;
        }
    }
}
