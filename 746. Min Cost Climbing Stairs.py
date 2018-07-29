#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/29 20:27'

#动态规划

#子问题关联
#dp[i]=min(dp[i+1]+cost[i],dp[i+2]+cost[i])


class Solution:
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        n=len(cost)
        dp=[0]*(n+1) #dp[n]表示在顶部后代价为零
        dp[n-1]=cost[n-1]
        for i in range(n-2,-1,-1):
            q1=cost[i]+dp[i+1]
            q2=cost[i]+dp[i+2]
            dp[i]=min(q1,q2)
        return min(dp[0],dp[1])