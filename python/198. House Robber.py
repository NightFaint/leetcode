#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/12 14:47'


# 带备忘的动态规划
# 子问题：nums[k+2:],k=0,1,2,...,n-1.共n个（抢了第一匹马，或抢第二匹马或...)
# 每个子问题有n-k-2个选择
# 计算复杂度：全部子问题的选择加起来：O(n^2)
# 空间复杂度:O(n)，存储最大收益列表m
# 原问题解m[0]
class Solution:
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)
        m = [-1] * n

        return self.memoized_rob(nums, m, 0, n - 1)

    def memoized_rob(self, nums, m, i, end):

        if m[i] >= 0:
            return m[i]
        if i == end:
            m[i] = nums[i]
        else:
            for k in range(i, end + 1):
                if k + 2 > end:
                    t = nums[k]
                else:
                    t = nums[k] + self.memoized_rob(nums, m, k + 2, end)
                if m[i] < t:
                    m[i] = t
        return m[i]

#自底向上的动态规划
#比第一个方法快，减少了函数调用的开销
#计算复杂度和space complexity和第一个方法相同
class Solution:
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n=len(nums)
        m = [-1]*n
        m[n-1]=nums[n-1]
        for i in range(n)[::-1]:
            for j in range(i,n):
                if j+2>n-1:
                    t=nums[j]
                else:
                    t=nums[j]+m[j+2]
                if m[i]<t:
                    m[i]=t
        return m[0]