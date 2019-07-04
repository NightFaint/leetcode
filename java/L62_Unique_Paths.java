public class L62_Unique_Paths {
    /**
     * T:O(mn),S:O(mn)
     * 动态规划
     * 子问题：m[i,j]表示到达(i,j)的路径数目
     * 子问题关联：m[i,j] = m[i-1,j] + m[i, j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] A = new int[m][n];
        A[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int num = 0;
                if (i > 0) {
                    num += A[i - 1][j];
                }
                if (j > 0) {
                    num += A[i][j-1];
                }
                A[i][j] = num;
            }
        }
        return A[m-1][n-1];
    }
}
