#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/17 20:07'


class Solution:
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # 计算复杂度O(n**2)
        # 92ms,击败94%
        import math

        closest = math.inf
        nums.sort()  # nlogn
        n = len(nums)
        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i - 1]:  # 不需要重复
                continue
            j = i + 1
            k = n - 1
            while j < k:
                total = nums[i] + nums[j] + nums[k]
                distance = abs(total - target)
                if distance < closest:
                    closest = distance
                    res = total
                if total == target:  # 相等的时候，距离是0，最短了，直接返回
                    return res
                elif total > target:  # 比目标值大，那么减少一点
                    k -= 1
                else:  # 比目标值小，增大一点
                    j += 1

        return res