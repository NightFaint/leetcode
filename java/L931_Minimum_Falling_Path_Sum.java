import java.util.Arrays;
import java.util.Collections;

public class L931_Minimum_Falling_Path_Sum {

    /**
     * 动态规划
     * dp[r][c]从第r行第c列开始的到底的路径的最小值
     * 则子问题关联为：
     * dp[r][c] = A[r][c] + min(dp[r+1][c-1], dp[r+1][c], dp[r+1][c+1])
     * 最问题的解为min(dp[0][c]),c=0,1,2,...,n-1
     * @param A
     * @return
     */
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        if (n == 1) {
            return A[0][0];
        }
        int[][] dp = new int[n][n];
        // 初始化，从最后一行开始的路径的最小值即是最后一行的元素本身
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = A[n - 1][i];
        }
        // n >= 2
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                if (col == 0) {
                    dp[row][col] = A[row][col] + Math.min(dp[row + 1][col], dp[row + 1][col + 1]);
                } else if (col == n - 1) {
                    dp[row][col] = A[row][col] + Math.min(dp[row + 1][col - 1], dp[row + 1][col]);
                } else {
                    dp[row][col] = A[row][col] + Collections.min(Arrays.asList(dp[row + 1][col - 1], dp[row + 1][col], dp[row + 1][col + 1]));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int x : dp[0]) {
            if (x < res) {
                res = x;
            }
        }
        return res;
    }

    /**
     * 上面方法的优化
     * @param A
     * @return
     */
    public int minFallingPathSum2(int[][] A) {
        int n = A.length;
        // 不用单独考虑n=1的情况，若n=1，则不会进入下面循环
        for (int row = n - 2; row >= 0; row--){
            for(int col = 0; col < n; col++) {
                int best = A[row + 1][col];
                if (col > 0) {
                    best = Math.min(best, A[row + 1][col - 1]);
                }
                if (col < n - 1) {
                    best = Math.min(A[row + 1][col + 1], best);
                }
                A[row][col] += best;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int x : A[0]) {
            if (x < res) {
                res = x;
            }
        }
        return res;
    }

}
