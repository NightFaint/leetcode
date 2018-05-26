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
                    
                    #c不是"("，便只能是")"，")"与前面序列的"("组合，stack长度减一
                    val=stack.pop()
                    stack[-1]+=val+2
                    #更新longest
                    longest=max(longest,stack[-1])
                    
                    
                #此时")"比"("还多，前面的序列对后续的最大组合无影响，即此时后续的“）”不会
                #与前面的序列中的“（”组成有效组合，可从下个字符开始计算后续序列的最大组合
                else:
                    stack=[0]
        return longest
                    
        
        