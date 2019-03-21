#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/9 0:17'

#复杂度：O(n)
#运行时间：114ms，超过7%
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # 设置两个左右两个指针，每次向中间移动高较小的指针，直到指针相遇，则所有可能的最大值已经全扫描过
        left = 0
        right = len(height) - 1
        max_area = 0
        while left < right:
            max_area = max(max_area, min(height[left], height[right]) * (right - left))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return max_area


#改进版：减少使用max,min函数带来的cost
#运行时间57ms，超过97.14%的提交
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        #设置两个左右两个指针，每次向中间移动高较小的指针，直到指针相遇，则所有可能的最大值已经全扫描过
        left=0
        right=len(height)-1
        max_area=0
        while left<right:
            if height[left]<height[right]:
                cur_area=height[left]*(right-left)
                if cur_area>max_area:
                    max_area=cur_area
                left+=1
            else:
                cur_area=height[right]*(right-left)
                if cur_area>max_area:
                    max_area=cur_area
                right-=1
        return max_area
