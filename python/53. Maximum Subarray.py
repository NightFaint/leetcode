#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/8/28 14:39'


class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 动态规划dp[i]表示以nums[i]为结尾的最大子字符串的值

        n = len(nums)
        dp = [''] * n
        dp[0] = nums[0]
        maxi = dp[0]
        for i in range(1, n):
            dp[i] = nums[i] + (dp[i - 1] if dp[i - 1] > 0 else 0)
            maxi = max(dp[i], maxi)
        return maxi