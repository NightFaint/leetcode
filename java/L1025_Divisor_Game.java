import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L1025_Divisor_Game {

    /**
     * DP
     * 子问题便是原问题
     * 可以被N整除的数:
     * for(int i = 1; i < N; i++) {
     *     if(N % i == 0 ) {
     *         return i;
     *     }
     * }
     * opposite函数，0 -> 1, 1 -> 0
     * 子问题关联dp[N] = max{opposite(dp[i])}
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        if (N < 2) {
            return false;
        }
        // space:O(n)
        int[] dp = new int[N + 1];
        dp[2] = 1;
        // T:O(n)
        for (int i = 3; i < N + 1; i++) {
            List<Integer> list = new ArrayList<>();
            // T:O(n)
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    list.add(opposite(dp[i - j]));
                }
            }
            // T:O(nlgn)
            dp[i] = Collections.max(list);
        }
        return dp[N] == 1;
    }

    private int opposite(int i) {
        if (i == 1) {
            return 0;
        } else if (i == 0) {
            return 1;
        } else {
            throw new RuntimeException("非法输入");
        }
    }

    /**
     * loser最后得到的数字一定是1，此时无法再移动（可用反证法证明）
     * so: dp[N] = !dp[N-1]
     * @param N
     * @return
     */
    public boolean divisorGame2(int N) {
        if (N == 1) {
            return false;
        }
        return !divisorGame2(N - 1);
    }

    /**
     * 详见https://leetcode.com/problems/divisor-game/discuss/321647/Proof-and-Optimal-Strategy-on-N20
     * @param N
     * @return
     */
    public boolean divisorGame3(int N) {
        return N % 2 == 0;
    }
}
