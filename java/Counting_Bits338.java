package leetcode;

/**
*思路：
*动态规划，刚开始考虑dp[i]和dp[i-1]的关系，发现当i为奇数时，dp[i]=dp[i-1]+1，偶数时找不到规律
*继续思考，i奇数时，dp[i]=dp[i-1]+1是因为i-1的最低位为0，而i的最低位为1，其他位相同，所以有dp[i]=dp[i-1]+1。
*那么，同样的思路，将i右移一位，便有dp[i]=dp[i>>1]+(i&1)
*计算复杂度O(n)，空间复杂度O(n)
*/

public class Counting_Bits338 {
    public int[] countBits(int num) 
    {
        ++num;
        int[] dp=new int[num];
        for(int i=1;i<num;++i)
        {
            dp[i]=dp[i>>1]+(i&1);
        }
        return dp;
    }
}
