#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/8/8 19:22'

class Solution1:
    # 动态规划
    # dp[i:j]=dp[i:j-1]+dp[i+1:j]-dp[i+1:j-1]+(1 if s[i:j+1]是回文串 else 0)
    # 子问题个数i=(0 to n-1)*j=(0 to n-1),为n^2
    # 复杂度为O(n)
    #很慢，击败4%
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dp = [[0] * n for i in range(n)]

        for i in range(n):
            for j in range(n):
                if i == j:
                    dp[i][j] = 1

        for l in range(2, n + 1):
            for i in range(0, n - l + 1):
                j = i + l - 1
                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1] + (1 if s[i:j + 1] == s[i:j + 1][::-1] else 0)

        return dp[0][n - 1]




class Solution2:
    def countSubstrings(self, s):
        # 动态规划
        # 思路：很明显dp[i]=dp[i-1]+以是s[i]为结尾的回文串的个数
        # 复杂度O(n^2)
        #很慢，击败29%
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dp1 = 1
        dp2 = 1

        for i in range(1, n):
            dp2 = dp1 + self.assist(s[:i + 1])
            dp1 = dp2

        return dp2

    def assist(self, s):
        count = 0
        s = s[::-1]
        cur_rev = ""
        cur = ""
        for i in range(len(s)):
            cur = s[:i + 1]
            cur_rev = cur[-1] + cur_rev
            if cur == cur_rev:
                count += 1
        return count


class Solution3:
    #较快，132ms。击败79%

    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)

        total = 0
        for i in range(n):
            t1 = self.assist(s, i, i)  # 以s[i]为中心的回文串的个数
            t2 = self.assist(s, i, i + 1)  # 以s[i]+s[i+1]为中心的回文串的个数
            total += t1 + t2

        return total

    def assist(self, s, left, right):
        count = 0
        while (left >= 0 and right < len(s) and s[left] == s[right]):
            count += 1
            left -= 1
            right += 1
        return count