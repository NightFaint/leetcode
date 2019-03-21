#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/5/3 17:02'

'''
结合21题的merge过程，这道题其实类似merge_sort的过程
复杂度：T(k)=2T(k/2)+theta(n)
假设theta(n)=theta(k)
根据master theory，condition 2：
T(k)=klgk
假设theat(n)=O(1)
T(k)=k
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummy = cur = ListNode(0)
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        cur.next = l1 or l2
        return dummy.next

    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        k = len(lists)
        if k == 1:
            return lists[0]
        elif k == 0:
            return None
        else:
            #basic condition 就是len(lists)=2,直接mergeTwoLists
            left = self.mergeKLists(lists[:k // 2])
            right = self.mergeKLists(lists[k // 2:])
            return self.mergeTwoLists(left, right)
'''
原来一个错误低效的方法：
T(k)=T(k-1)+theta(n)
复杂度：O(k*n)
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        k=len(lists)
        if k == 1:
            return lists[0]
        elif k == 0:
            return None
        elif k == 2:
            return self.mergeTwoLists(lists[0],lists[1])
        while k > 2:
            last_two_listNode = self.mergeTwoLists(lists[-1],lists[-2])
            lists.pop() #O(1)
            lists.pop()#O(1)
            lists.append(last_two_listNode)#O(1)
            return self.mergeKLists(lists)
'''