#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/7 13:24'

#solution1


#O(n)
class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        DICT={}
        length=len(nums)
        i=0
        while i <= length-1:
            #刚开始用的是列表来存储已经存在的数据，每次in的操作复杂度都是O(k)，最后总的为O(nlgk)，通不过测试。改为字典后通过了
            if nums[i] in DICT:#O(1)
                nums.remove(nums[i])
                length-=1

            else:
                DICT.setdefault(nums[i],1)
                i+=1

        return len(nums)
#一次错误的尝试
#最后的结果是错误的，因为for循环每次i都会增加，而nums删除元素后长度已经变了，有些元素会被跳过
class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lst=[]
        length=len(nums)
        i=0
        while i < length-1:
            if nums[i] in lst:
                nums.remove(nums[i])
                length-=1
            else:
                lst.append(nums[i])
                i+=1
        return len(nums)

#solution2
#这个方法简单而且快多了，击败了所有leetcode上python提交的方法
class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #O(n)
        nums[:]=list(set(nums))
        nums.sort()
        return len(nums)