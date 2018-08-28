#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/8/28 14:41'

class Solution:
    def numberOfArithmeticSlices(self, A):
        dp=0
        j=0
        summ=0
        for i in range(1,len(A)-1):
            if A[i-1]-A[i] == A[i]-A[i+1]:
                j+=1
                dp+=j
            else:
                j=0
                summ+=dp
                dp=0
        summ+=dp
        return summ