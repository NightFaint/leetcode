#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/25 16:49'


class Solution:
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        # 复杂度O(n**3)
        # 递归。92ms，击败98%

        def find_N_Sum(nums, target, N, result, results):
            n = len(nums)
            if n < N or nums[0] * N > target or nums[-1] * N < target:
                return
            if N == 2:
                l = 0
                r = n - 1
                while l < r:
                    two_sum = nums[l] + nums[r]
                    if two_sum == target:
                        results.append(result + [nums[l], nums[r]])
                        while l < r and nums[l] == nums[l + 1]:
                            l += 1
                        while l < r and nums[r] == nums[r - 1]:
                            r -= 1
                        l += 1
                        r -= 1
                    elif two_sum < target:
                        l += 1
                    else:
                        r -= 1
            else:
                for i in range(n - N + 1):
                    if i == 0 or (i > 0 and nums[i] != nums[i - 1]):
                        find_N_Sum(nums[i + 1:], target - nums[i], N - 1, result + [nums[i]], results)

        nums.sort()
        n = len(nums)
        result = []
        results = []
        find_N_Sum(nums, target, 4, result, results)
        return results
