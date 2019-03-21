#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/20 20:25'


class Solution:
    def advantageCount(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        # 让A和B都排好序（B要保留原来的索引），然后从小到大开始比较，
        # 如果A[i]>B[j],那么A[i]应该放在索引B[j]（即比A[i]小比A[i-1]大的最小值）原来的索引处，
        # 如果A[i]<=B[j]，说明此时A[i]无法增加比较优势，把他放在最左边，让它与B的最大值或第k大值比较，类似田忌赛马
        A.sort()
        B = [[i, B[i], 0] for i in range(len(B))]
        B.sort(key=lambda x: x[1])
        i = 0
        j = 1
        for p in A:
            if p > B[i][1]:
                B[i][2] = p
                i += 1
            else:
                B[-j][2] = p
                j += 1
        B.sort(key=lambda x: x[0])

        return [i[2] for i in B]