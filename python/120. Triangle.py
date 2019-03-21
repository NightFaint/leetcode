#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/13 10:45'


'''
子问题：prefix[:i],共n个
m记录的是当前行的每一个元素的minimun path sum,与以往不同，m不再保持子问题的记录，用完即更新，节省了space
topological order:0——>n-1

'''
class Solution(object):

    def minimumTotal(self, triangle):
        if not triangle or not triangle[0]:
            return 0
        m = [triangle[0][0]]
        for i in range(1, len(triangle)):
            row = triangle[i]
            m.append(row[-1] + m[-1])#必须在m[1,..,n-2]中间元素修改前修改m[-1]，因为m[-1]受中间元素影响
            for j in range(i-1, 0, -1):
                m[j] = row[j] + min(m[j], m[j-1])
            m[0] = row[0] + m[0]#必须在m[1,..,n-2]中间元素修改完再修改m[0]，因为m[0]会影响m[1]
        return min(m)        