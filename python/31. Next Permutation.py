#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/20 23:03'

class Solution:
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        tag=True #记录是否是最大的排列
        #第一个for循环查找第一个不是最大排列的子串nums[i:]，找到，则停止循环
        for i in range(n-1)[::-1]:
            if nums[i+1] > nums[i]:
                tag=False #不是最大的排列
                #第二个for循环查找nums[i+1:]中第一个比nums[i]大的数nums[j]，交换两者位置，然后nums[i+1]从小到大排列
                for j in range(i+1,n)[::-1]:
                    if nums[j] > nums[i]:
                        nums[i],nums[j]=nums[j],nums[i]
                        nums[i+1:]=sorted(nums[i+1:])
                        break
                #nums[i],nums[i+1:]=nums[n-1],nums[i:n-1]
                break
        #如果nums已经是最大排列，则将nums从小到大排列
        if  tag:
            nums.sort()