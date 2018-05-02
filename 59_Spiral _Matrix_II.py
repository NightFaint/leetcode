#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/2 13:46'

class Solution:
    def generateMatrix(self, n):
        """
        复杂度：O(n^2)
        :type n: int
        :rtype: List[List[int]]
        """
        origin = n
        #初始化矩阵
        lst=[]
        for i in range(n):
            lst.append([x for x in range(1,n+1)])
        start = 0 #记录每次开始时的正方形框第一个元素的大小
        num = 0#记录循环了多少次
        while n > 1:
            #给正方形框的第一行赋值
            lst[0+num][num:n+num] = [x for x in range(start+1,start+n+1)]
            for i in range(1,n-1):
                #正方形框右边的边（除去正方形框第一行和最后一行）赋值
                lst[num+i][num-1+n]=start+n+i
                #正方形框左边的边（除去正方形框的第一行和最后一行）赋值
                lst[num+i][num]=start+3*n-2+n-2-i+1
            #正方形框最后一行赋值
            lst[num+n-1][num:n+num] = [x for x in range(start+2*n-1,start+3*n-1)][::-1]
            #记录每次结束时的最大值
            start += (n-1)*4
            #每次正方形框边长减2
            n-=2
            #循环次数
            num+=1
        #如果矩阵初始边长是奇数，那么最后剩正中间的值还没赋予，如果是偶数，那么可以全部分解为多个正方形框
        if n == 1:
            lst[origin//2][origin//2]=origin**2
        return lst