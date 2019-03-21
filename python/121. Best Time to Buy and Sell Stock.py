#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/29 20:29'


#动态规划

#子问题关联
#最大收益有以下两种情况：
#今天买入，则最大收益为接下来几天最高值减去买入值
#今天不买入，则最大收益dp[i]与dp[i+1]相同
#两者取最大值

#基本问题：dp[n-1]=0，到了最后一天还操作的话收益为零

class Solution1:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        res=[0]*len(prices)
        max_sell=prices[len(prices)-1]
        for i in range(len(prices)-2,-1,-1):
            if prices[i]>max_sell:
                max_sell=prices[i]#将每一天的价格与之后的最高价格相比较，记录最高价格
            q=max_sell-prices[i]
            if q>res[i+1]:
                res[i]=q
            else:res[i]=res[i+1]
        return res[0]


class Solution2:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        mini = 2 ** 31
        maxi = 0
        for p in prices:
            if p < mini:
                mini = p
            elif p - mini > maxi:
                maxi = p - mini
        return maxi
