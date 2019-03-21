#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/20 20:27'

import collections
class Solution:
    def reorderedPowerOf2(self, N):
        """
        :type N: int
        :rtype: bool
        """
        #只要统计str(N)每个元素的个数，与2的n次方比较便可
        s=str(N)
        c=collections.Counter(s)
        len_of_n=len(s)
        power=1
        while True:
            len_of_power=len(str(power))
            if len_of_power > len_of_n:
                break
            if len_of_power == len_of_n and collections.Counter(str(power)) == c:
                return True
            power=power<<1
        return False