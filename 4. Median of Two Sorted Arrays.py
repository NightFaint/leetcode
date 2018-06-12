#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/13 0:03'

#复杂度O(log(min(m,n)))，击败99.47%
#参考博文https://blog.csdn.net/chen_xinjia/article/details/69258706
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        import math
        math.inf
        n1=len(nums1)
        n2=len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2,nums1)
        if n1 == 0:
            return (nums2[n2//2]+nums2[(n2-1)//2])/2
        size = n1+n2
        cut1L=0
        cut1R=n1
        cut1=n1//2
        cut2=size//2-cut1
        while cut1<n1:
            cut1=(cut1L+cut1R)//2
            cut2=size//2-cut1
            L1 = -math.inf if cut1==0 else nums1[cut1-1]
            L2 = -math.inf if cut2==0 else nums2[cut2-1]
            R1 = math.inf if cut1==n1 else nums1[cut1]
            R2 = math.inf if cut2==n2 else nums2[cut2]
            if L1 > R2:
                cut1R = cut1-1
            elif L2 > R1:
                cut1L = cut1+1
            else:
                if size %2==0:
                    L1=L1 if L1>L2 else L2
                    R1=R1 if R1<R2 else R2
                    return (L1+R1)/2
                else:
                    R1=R1 if R1<R2 else R2
                    return R1