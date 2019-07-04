public class L63_Unique_PathsII {
    /**
     * 和上一道题类似，只不过当obstacleGrid[i][j] = 1时，m[i,j] = 0
     * 上一道题思路：
     * 动态规划
     * 子问题：m[i,j]表示到达(i,j)的路径数目
     * 子问题关联：m[i,j] = m[i-1,j] + m[i, j-1]
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 起点是1，则无路径
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        // 在原始数组中记录m[i][j]，节省空间
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    int num = 0;
                    if (i > 0) {
                        num += obstacleGrid[i - 1][j];
                    }
                    if (j > 0) {
                        num += obstacleGrid[i][j - 1];
                    }
                    obstacleGrid[i][j] = num;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
