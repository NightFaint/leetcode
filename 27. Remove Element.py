#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/7 14:00'

import bisect
class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        #O(nlgn)
        nums.sort()#O(nlgn)
        #二分查找找到val的最早出现的位置
        indexleft=bisect.bisect_left(nums,val)#O(lgn)
        #二分查找找到val的最后出现的位置
        indexright=bisect.bisect(nums,val)#O(lgn)
        nums[indexleft:indexright]=[]#O(1)
        return len(nums)