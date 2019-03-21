#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/20 20:33'

class Solution:
    def rotateString(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: bool
        """
        if max(len(A),len(B))>100:
            return 'Length is too large'
        if len(A) !=len(B):
            return False
        lst=[A,]
        for i in range(len(A)):
            lst.append(A[i+1:]+A[:i+1])
        if B in lst:
            return True
        else:return False