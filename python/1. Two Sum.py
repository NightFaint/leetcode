#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/31 16:53'


# 复杂度O(n)
# 空间复杂度O(n)

class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        # 构造字典，键为nums值，value为nums索引，O(n)
        hash_table = {}
        for index, value in enumerate(nums):
            hash_table[value] = index

        for i in range(len(nums)):
            if target - nums[i] in hash_table.keys():  # 字典查找，平均每次O(1)
                if hash_table[target - nums[i]] != i:  # 排除自身
                    return [i, hash_table[target - nums[i]]]