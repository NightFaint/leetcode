#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/28 11:01'

class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        #复杂度O(lgn)
        #36ms，击败99%
        mid = len(nums)//2
        if nums[0] > target:
            return 0
        elif nums[-1] < target:
            return len(nums)
        if nums[mid]==target:
            return mid
        elif nums[mid] > target:
            return self.searchInsert(nums[:mid],target)
        else:
            return mid+1+self.searchInsert(nums[mid+1:],target)