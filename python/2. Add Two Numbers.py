#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/6/12 21:41'

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#复杂度O(n)，136ms，击败26.6%
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        res=[]
        count=0 #用来记录是否需要进位
        while l1 and l2: #当链表l1和l2都还有元素时
            num = l1.val+l2.val+count
            count = 0
            if num > 9:
                count += 1
                num-=10
            res.append(num)
            l1=l1.next
            l2=l2.next
        if l2:#链表l1没元素了，只剩下l2，注意此时需要加上之前进位的count
            while l2:
                num = l2.val+count
                count=0
                if num>9:
                    count+=1
                    num-=10
                res.append(num)
                l2=l2.next
        if l1:
            while l1:
                num = l1.val+count
                count=0
                if num>9:
                    count+=1
                    num-=10
                res.append(num)
                l1=l1.next
        if count:#最后，当两个链表都没有元素时，记得看最后一位是否进位了
            res.append(count)
        return res


# 复杂度O(n)  160ms，击败31%
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummy = cur = ListNode(0)
        count = 0  # 用来记录是否需要进位
        while l1 or l2 or count:
            if l1:
                count += l1.val
                l1 = l1.next
            if l2:
                count += l2.val
                l2 = l2.next
            cur.next = ListNode(count % 10)
            cur = cur.next
            count = count // 10  # 看是否需要进位

        return dummy.next
