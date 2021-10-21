class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int range = 0;
                while (isAllOnes(matrix, i, j, range)) {
                    result += 1;
                    range +=1;
                    if (range + i >= m || range + j >= n) break;
                }
            }
        }
        
        return result;
    }
    private boolean isAllOnes(int[][]matrix, int x, int y, int range) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] moves = {{1 + range, 1 + range}, {1 + range, 0}, {0, 1 + range}};
        
        for (int i = x; i <= x + range; i++) {
            for (int j = y; j <= y + range; j++) {
                if (matrix[i][j] == 0) return false;
            }
        }
        return true;
    }
}