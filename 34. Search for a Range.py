#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/29 23:58'


class Solution:
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums or target is None:
            return [-1, -1]
        start = self.findfirst(nums, target)
        if start == -1:
            return [-1, -1]
        end = self.findlast(nums, target)
        return [start, end]

    def findfirst(self, nums, target):
        start = 0
        end = len(nums) - 1
        while start < end - 1:
            mid = (start + end) // 2
            if nums[mid] < target:
                '''
                不能改成lastfind的
                if nums[mid]>target:
                    end=mid
                else:
                    start=mid
                这样相当于是
                if nums[mid]<=target:
                    start=mid
                else:
                    end=mid
                当nums[mid] = target时，start=mid，此时可能已经跳过了第一个target
                '''
            start = mid
        else:
            end = mid  # nums[end]始终保证大于或等于target

    # nums[start]始终是小于或等于(当开始时，如start=0时就等于target)target的，所以如果等于target，那么是第一个
        if nums[start] == target:
            return start
        if nums[end] == target:
            return end
        return -1


    def findlast(self, nums, target):
        start = 0
        end = len(nums) - 1
        while start < end - 1:
            mid = (start + end) // 2
            if nums[mid] > target:
                end = mid
            else:
                start = mid
        if nums[end] == target:
            return end
        if nums[start] == target:
            return start

        return -1
