class Solution:
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = [0]
        longest=0
        
        for c in s:
            if c=='(':
                stack.append(0) #stack的长度是有待组合的"("的个数+1
            else:
                if len(stack) >1:#len(stack)>1，说明前面的序列至少有一个"("待组合
                    
                    #c不是"("，便只能是")"，")"与前面序列的"("组合，stack长度减一，
                    val=stack.pop()
                    stack[-1]+=val+2#此时stacl[-1]表示前面已匹配完(的序列的长度,val表示前面序列匹配一部分，但仍有待匹配的长度，如:()(()),当c=最后一个)时，
                    # stack[-1]表示第一个()长度，2；val表示(()长度，2。
                    #更新longest
                    longest=max(longest,stack[-1])
                    
                    
                #此时")"比"("还多，前面的序列对后续的最大组合无影响，即此时后续的“）”不会
                #与前面的序列中的“（”组成有效组合，可从下个字符开始计算后续序列的最大组合
                else:
                    stack=[0]
        return longest


#another solution
class Solution:
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        if n < 2:
            return 0
        stack = []
        start = -1  # (开始的位置
        longest = 0
        for i in range(n):
            if s[i] == '(':
                stack.append(i)
            elif stack == []:
                start = i
            else:
                stack.pop()
                if stack == []:
                    longest = max(longest, i - start)
                else:
                    longest = max(longest, i - stack[-1])  # 如果堆非空，即仍有(待匹配，不能从(开始的地方计数，应从最后一个待匹配的(的位置开始计数
        return longest


class Solution3:
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 动态规划，复杂度O(n)
        # dp[i]:以s[i]为结尾的longest valid parentheses substring的长度。
        # 通项公式：
        # 如果s[i]='(',dp[i]一定为0，因为以'('结尾的不可能是有效字符串
        # 如果s[i]=')'
        # 找i前一个字符s[i-1]的最长括号串DP[i-1]的前一个字符j = i-1-DP[i-1]
        # 如果j>0且s[j]='('，那么dp[i]=2+dp[i-1]+dp[j-1]
        # j可能为零，那么dp[j-1]=dp[-1]，dp[-1]应该无效，而python此时中dp[-1]=dp[i],因为初始化为零，即使加上也无所谓
        # 如果j<0或者s[j]=')',dp[i]=0

        n = len(s)
        dp = [0] * n
        longest = 0
        for i in range(1, n):
            j = i - 1 - dp[i - 1]
            if s[i] == '(' or j < 0 or s[j] == ')':
                dp[i] = 0
            else:
                dp[i] = 2 + dp[i - 1] + dp[j - 1]
                longest = max(longest, dp[i])
        return longest
        
        