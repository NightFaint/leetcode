#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/8/28 14:32'


# 动态规划
# 子问题关联公式：
# dp[i,j]=max{
# min(dp[i+1,j-1],dp[i+2,j])+piles[i],   #由于双方都采取最优策略，所以轮到对方时它会选取对自己最优的策略，使得对于我方min(dp[i+1,j-1],dp[i+2,j])
# min(dp[i,j-2],dp[i+1,j-1])+piles[j]    #对于dp[i,j],j<i的情况，没意义，dp[i,j]=0
#         }
# 对于我方，是取的最大的石头数

# 复杂度O(n**2)
class Solution:
    def stoneGame(self, piles):
        """
        :type piles: List[int]
        :rtype: bool
        """

        n = len(piles)
        dp = [[0] * n for i in range(n)]
        for le in range(1, n + 1):
            for i in range(n - le + 1):
                j = i + le - 1
                d1 = dp[i + 1][j - 1] if j - 1 >= i + 1 else 0
                d2 = dp[i + 2][j] if j >= i + 2 else 0
                d3 = dp[i][j - 2] if j - 2 >= i else 0
                d4 = d1
                q1 = min(d1, d2)
                q2 = min(d3, d4)
                dp[i][j] = max(q1 + piles[i], q2 + piles[j])
        return dp[0][n - 1] > sum(piles) / 2