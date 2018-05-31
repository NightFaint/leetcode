#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/31 19:30'


#复杂度：O(n^2)

class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        n=len(nums)
        res=[]
        nums.sort()
        for i in range(n):
            if i==0 or (i>0 and nums[i]!=nums[i-1]):
                #两个指针，一个从左，一个从右开始
                start=i+1
                end=n-1
                while start<end:
                    sum_3=nums[i]+nums[start]+nums[end]
                    if  sum_3 == 0:#三数相加等于0，则添加到res中，同时左指针加1，右指针减1。同时为了避免重复，如果左指针加1仍相等，继续加1.右指针同理
                        res.append([nums[i],nums[start],nums[end]])
                        while start<end and nums[start] == nums[start+1]:
                            start+=1
                        while start<end and nums[end] == nums[end-1]:
                            end-=1
                        start+=1
                        end-=1
                    elif sum_3<0 :
                        start+=1#三数之和小了，说明需要更大的数，左指针加1变大
                    else:#三数之和大了，说明需要更小的数，右指针减1变小
                        end-=1
        return res

#另一种解法，也是O(n)
class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        n=len(nums)
        res=set()
        if n<3:
            return []
        for i in range(n-2):
            if i >= 1 and nums[i] == nums[i-1]:
                continue
            d=set()
            for x in nums[i+1:]:
                #d中存储了0-x-v的值，即待需匹配的值，如果x在d中，说明x和之前的两个数一起相加为0
                if x not in d:
                    d.add(-x-nums[i])
                else:
                    res.add((nums[i],x,-nums[i]-x))
        return list(map(list,res))