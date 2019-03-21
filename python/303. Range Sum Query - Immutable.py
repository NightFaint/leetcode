#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/29 20:29'


def __init__(self, nums):
    """
    :type nums: List[int]
    """
    self.nums = nums
    self.res = [0] * len(nums)
    if len(nums) >= 1:
        self.res[0] = nums[0]
        for i in range(1, len(nums)):
            self.res[i] = self.res[i - 1] + nums[i]


def sumRange(self, i, j):
    """
    :type i: int
    :type j: int
    :rtype: int
    """
    return self.res[j] - self.res[i] + self.nums[i]