#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/20 20:30'

class Solution:
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        n=len(A)
        m=len(A[0])
        r=[' ']*n
        B=[r[:] for i in range(m)]
        for i in range(n):
            for j in range(m):
                B[j][i]=A[i][j]
        return B