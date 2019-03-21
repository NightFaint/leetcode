#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/20 23:04'


class Solution:
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        # 判断结果是否为负
        neg = (dividend > 0) ^ (divisor > 0)
        # 取绝对值
        dividend, divisor = abs(dividend), abs(divisor)

        # count记录结果，即倍数
        # i记录被除数最多是除数的偶数倍，即2,4,8，...
        count = 0
        while dividend >= divisor:
            i = 0
            while dividend > (divisor << (i + 1)):
                i += 1
            dividend -= divisor << i
            count += 1 << (i)

        return -count if neg else min(count, 2 ** 31 - 1)