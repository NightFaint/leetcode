#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/8/28 14:38'
#动态规划
#计算复杂度都是O(n),空间复杂度O(1)
#dp[i]=dp[i-1]+dp[i-2]，其实类似于斐波那契数列
#dp[1]=1,dp[0]=1
class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n<3:
            return n
        #dp=[0]*(n+1)
        pre=1
        cur=2
        for i in range(3,n+1):
            cur,pre=cur+pre,cur

        return cur
