import org.junit.Test;

public class L91_Decode_Ways {
    /**
     * DP
     * len = s.length()
     * DP(n)表示从0到n-1的子字符串的解码方法的数量
     * 则原问题 = DP（n）
     * DP(0) = 1
     * DP(1) = s.charAt(0) == '0' ? 0 : 1
     * DP(i) = DP(i-1) +DP(i-2) if 1 <= s.chatAt(i-1) <= 9 && if 10 <= s.subString(i-2, i) <= 26
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (one >= 1 && one <= 9) {
                dp[i] += dp[i - 1];
            }
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        int i = numDecodings("01");
        System.out.println(i);
    }
}
