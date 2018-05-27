#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/27 19:58'


class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums or target is None:
            return -1
        n = len(nums)
        start = 0
        end = n - 1
        while start + 1 < end:
            mid = (end - start) // 2 + start
            if nums[mid] == target:
                return mid
            elif nums[start] < nums[mid]:  # mid左边是递增序列，可以二分查找
                if nums[start] <= target and target <= nums[mid]:  # target在左边部分，end=mid-1（上一个if已验证nums[mid]是不是target
                    end = mid - 1
                else:  # target在右边部分，start=mid+1
                    start = mid + 1
            else:  # 右边部分是递增序列，可以二分查找
                if nums[mid] <= target and target <= nums[end]:  # target在右边部分，start=mid+1
                    start = mid + 1
                else:  # target在左边部分，end=mid-1
                    end = mid - 1
        if nums[start] == target: return start
        if nums[end] == target: return end
        return -1


