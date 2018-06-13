#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/13 21:53'

class Solution1:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        #暴力解法，复杂度O(n^3),5000ms,击败17%
        #找出每一个可能的最大回文数，长度为1，为2的，为3的，...为n的
        n = len(s)
        if s == s[::-1]:#s为''或者本身是回文数，返回自身
            return s
        store=[]
        for i in range(1,n):#查找各种长度的回文数
            for j in range(n-i+1):
                if s[j:j+i] == s[j:j+i][::-1]:
                    store.append(s[j:j+i])
                    break #一旦长度为i的发现回文数，不必再查找该长度下剩下的了
        #返回最大的回文数
        maxsub=''
        for sub in store:
            if len(sub) > len(maxsub):
                maxsub=sub
        return maxsub

class Solution2:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # This is a DP solution,3500ms,击败30%,复杂度O(n^2)
        # dp[i][j] represnets if s[i:j+1] is palindrome
        # dp[i][j] = dp[i+1][j-1] and s[i] == s[j]
        # It seems the formula only refers to i+1 and j-1 so only need to store dp[i] and dp[i+1]
        if not s: return s
        n = len(s)
        #dp = [[False] * n for _ in range(n)]
        dp = [[False] * n for _ in range(2)]
        max_len = float('-inf')
        max_index = (0, 0)
        for i in reversed(range(n)):
            for j in range(i, n):
                if i == j: dp[0][j] = True
                elif i + 1 == j and s[i] == s[j]: dp[0][j] = True
                else:
                    dp[0][j] = s[i] == s[j] and dp[1][j-1]
                if dp[0][j] and j - i + 1 > max_len:
                    max_len = j - i + 1
                    max_index = (i, j)
            # ping pong
            dp[0], dp[1] = dp[1], dp[0] #不能只写dp[1]=dp[0]，若这样dp[0]和dp[1]都是对同一个列表的引用，dp[0]变化的时候dp[1]也会变，导致dp[1][j-1]不是原来的dp[1][j-1]
        return s[max_index[0]:max_index[1]+1]

class Solution3:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        #复杂度O(n^2),118ms，击败86%
        if len(s) == 0:
            return 0
        maxlen =1
        start = 0
        #最大回文数扩展有两种类型，一次加长两位，如abba到eabbae;一次加长以为，如b到bb
        for i in range(len(s)):
            #加长两位
            if i - maxlen - 1>= 0  and s[i-maxlen-1:i+1] == s [i-maxlen-1:i+1][::-1]:
                #i-maxlen-1>=0确保s[:i+1]至少比maxlen大两位，这样才有可能添加两位
                #s[i-maxlen-1:i+1]确保这个字符串比maxlen长2
                start = i - maxlen-1
                maxlen +=2
                continue
            if i -maxlen >=0 and s[i-maxlen:i+1]==s[i-maxlen:i+1][::-1]:
                start=i-maxlen
                maxlen+=1
                continue
        return s[start:start+maxlen]