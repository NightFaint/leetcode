#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/20 20:28'

class Solution:
    def binaryGap(self, N):
        """
        :type N: int
        :rtype: int
        """
        bi=bin(N)
        dis=[]
        max_dis=0
        for i,v in enumerate(bi[2:]):
            if v == '1':
                dis.append(i)
                if len(dis)>1:
                    cur_dis=dis[-1]-dis[-2]
                    if cur_dis>max_dis:
                        max_dis=cur_dis
        return max_dis